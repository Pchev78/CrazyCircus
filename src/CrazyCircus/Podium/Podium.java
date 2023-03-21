package CrazyCircus.Podium;

import CrazyCircus.Animal.Animal;

import java.io.StringReader;
import java.util.ArrayList;

public class Podium {
    private String nom; // Nom du podium : soit bleu, soit rouge
    private ArrayList<Animal> animaux = new ArrayList<>(); // Tableau des animaux du podium

    // Constructeur de Podium
    public Podium(String nom) {
        this.nom = nom;
    }

    /**
     * @brief Getter pour le nom
     * @return le nom du podium
     */
    public String recupererNom() {
        return this.nom;
    }

    /**
     * @brief Getter les animaux du podium
     * @return les animaux du podium
     */
    public ArrayList<Animal> recupererAnimaux() {
        return this.animaux;
    }


    /**
     * @brief Textualise le tableau d'animaux
     * @return la chaîne de caractères contenant les animaux d'un podium
     */
    public String toString() {
        String libelle = "Podium " + this.nom + " :\n";

        for (int i = 0; i < this.animaux.size(); i++) {
            libelle+=this.animaux.get(i).recupereNom() + "\n";
        }

        return libelle;
    }

    /**
     * @brief ajoute un animal à un podium
     * @param animalAAjouter : l'animal que l'on veut ajouter
     */
    public void ajouteAnimal(Animal animalAAjouter) {
//        for (Animal animal : animaux){
//            if (animaux.contains(animal))
//                return; // @TODO Ajouter une erreur
//        }
        this.animaux.add(animalAAjouter); // @TODO Vérifier que la fonction marche
    }

    /**
     * @brief Donne l'animal au sommet du podium
     * @pre On vérifie qu'il y ait au moins un animal sur le podium
     * @return l'animal au sommet du podium
     */
    public Animal recupereAnimalEnHautDePile() throws Exception {
        this.verifieAnimauxExisteSurPodium();

        return this.animaux.get(0);
    }

    /**
     * @brief Donne l'animal en bas du podium
     * @pre On vérifie qu'il y ait au moins un animal sur le podium
     * @return L'animal en bas du podium
     */
    public Animal recupereAnimalEnBasDePile() throws Exception {
        this.verifieAnimauxExisteSurPodium();

        int indexAnimalEnBasDePile = this.animaux.size() - 1;
        return this.animaux.get(indexAnimalEnBasDePile);
    }

    /**
     * @brief Retir un animal du podium
     * @param animal : l'animal que l'on veut retirer
     */
    public void retirerAnimal(Animal animal)
    {
        for (int i=0; i < this.animaux.size(); i++) {
            if (this.animaux.get(i).recupereNom() == animal.recupereNom()) {
                this.animaux.remove(i);
            }
        }
    }

    /**
     * @brief Met l'animal donné en paramètre au sommet du podium
     * @param animal : l'animal que l'on veut mettre au sommet du podium
     */
    public void metAnimalAuSommet(Animal animal) {
        this.animaux.add(0, animal);
    }

    /**
     * @brief Verifie qu'il y ait au moins un animal sur le podium
     */
    private void verifieAnimauxExisteSurPodium() throws Exception {
        if (this.animaux.size() == 0) {
            throw new Exception("Le podium " + this.nom + " est vide");
        }
    }
}
