package CrazyCircus;

import CrazyCircus.Podium.Bleu;
import CrazyCircus.Podium.Podium;
import CrazyCircus.Podium.Rouge;
import CrazyCircus.Animal.Animal;

import java.util.ArrayList;

public class Situation {
    private Bleu podiumBleu;
    private Rouge podiumRouge;

    // Constructeur de la situation
    public Situation(Bleu podiumBleu, Rouge podiumRouge) {
        this.podiumBleu = podiumBleu;
        this.podiumRouge = podiumRouge;
    }

    /**
     * @brief Getter du podium bleu
     * @return le podium bleu
     */
    public Bleu recupererPodiumBleu() {
        return this.podiumBleu;
    }

    /**
     * @brief Getter du podium rouge
     * @return le podium rouge
     */
    public Rouge recupererPodiumRouge() {
        return this.podiumRouge;
    }

    /**
     * @brief Lit les ordres et appelle la fonction permettant de les exécuter
     * @param ordres : ordres à exécuter
     */
    public void executerOrdres(ArrayList<Ordres> ordres) {
        for (Ordres ordre : ordres) {
            this.executerOrdre(ordre);
        }
    }

    /**
     * @brief Permet d'afficher la situation avec les podiums contenus dedans
     * @return la chaîne de caractères représentant les podiums
     */
    public String toString() {
        return this.podiumBleu.toString() + "\n" + this.podiumRouge.toString();
    }

    /**
     * @brief Permet d'exécuter un ordre.
     * @param ordre : ordre à exécuter
     */
    private void executerOrdre (Ordres ordre) {
        {
            try {
                if (ordre == Ordres.KI) {
                    // L’animal se trouvant en haut de la pile du podium bleu saute pour rejoindre le sommet de la pile du podium rouge
                    this.changePodium(this.podiumBleu, this.podiumRouge);
                } else if (ordre == Ordres.LO) {
                    // L’animal se trouvant en haut de la pile du podium rouge saute pour rejoindre le sommet de la pile du podium bleu
                    this.changePodium(this.podiumRouge, this.podiumBleu);
                } else if (ordre == Ordres.SO) {
                    // Les deux animaux se trouvant au sommet des piles des deux podiums échangent leur place.
                    this.changeAnimauxAuxSommets();
                } else if (ordre == Ordres.NI) {
                    // L’animal se trouvant en bas de la pile du podium bleu monte et se place en haut de la pile de ce même podium
                    this.metAnimalAuSommet(this.podiumBleu);
                } else if (ordre == Ordres.MA) {
                    // L’animal se trouvant en bas de la pile du podium rouge monte et se place en haut de la pile de ce même podium
                    this.metAnimalAuSommet(this.podiumRouge);
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    /**
     * @brief Fait sauter un animal d'un podium à un autre
     * @param podiumDepart : le podium sur lequel était l'animal
     * @param podiumArrive : le podium sur lequel l'animal va sauter
     */
    private void changePodium(Podium podiumDepart, Podium podiumArrive) throws Exception {
        Animal AnimalEnHautDePile = podiumDepart.recupereAnimalEnHautDePile();
        podiumDepart.retirerAnimal(AnimalEnHautDePile);
        podiumArrive.metAnimalAuSommet(AnimalEnHautDePile);
    }

    /**
     * @brief Permet de changer les animaux aux sommets des podiums
     */
    private void changeAnimauxAuxSommets() throws Exception {
        Animal AnimalEnHautDePileDepart = this.podiumBleu.recupereAnimalEnHautDePile();
        Animal AnimalEnHautDePileArrivee = this.podiumRouge.recupereAnimalEnHautDePile();

        this.podiumBleu.retirerAnimal(AnimalEnHautDePileDepart);
        this.podiumRouge.retirerAnimal(AnimalEnHautDePileArrivee);

        this.podiumRouge.metAnimalAuSommet(AnimalEnHautDePileDepart);
        this.podiumBleu.metAnimalAuSommet(AnimalEnHautDePileArrivee);
    }

    /**
     * @brief Permet de mettre un animal sur le podium reçu en paramètre
     * @param podium : podium sur lequel l'animal va aller
     */
    private void metAnimalAuSommet(Podium podium) throws Exception {
        Animal animal = podium.recupereAnimalEnBasDePile();
        podium.retirerAnimal(animal);
        podium.metAnimalAuSommet(animal);
    }
}

