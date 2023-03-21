package CrazyCircus;

import CrazyCircus.Animal.Animal;
import CrazyCircus.Animal.Elephant;
import CrazyCircus.Animal.Lion;
import CrazyCircus.Animal.Ours;
import CrazyCircus.Podium.Bleu;
import CrazyCircus.Podium.Podium;
import CrazyCircus.Podium.Rouge;

import java.util.ArrayList;

public class Carte {
    private ArrayList<Situation> situations = new ArrayList<>();

    // Constructeur de la classe Carte
    public Carte() {
        this.creerSituations();
    }

    /**
     * @brief Getter d'une situation
     * @param index : index de la situation que l'on veut choisir
     * @pre On vérifie que l'index est bien correct
     * @return la situation à la position index
     */
    public Situation recupererSituation(int index) throws Exception {
        this.verifierIndexSituation(index);
        return this.situations.get(index);
    }

    /**
     * @brief Getter du nombre de situations
     * @return le nombre de situations
     */
    public int recupererTailleSituations() {
        return this.situations.size();
    }

    /**
     * @brief Sert à vérifier que l'index donné d'une situation est bien valide
     * @param index : position de la situation que l'on veut vérifier
     */
    private void verifierIndexSituation(int index) throws Exception {
        if (index < 0 || index > this.situations.size()) {
            throw new Exception("index invalide. Il doit être compris entre 0 et " + this.situations.size());
        }
    }

    /**
     * @brief Crée toutes les situations possibles
     */
    private void creerSituations() {
        this.creerCartePodiumVide();
        this.creerCartePodium1Animal();
    }

    /**
     * @brief Crée toutes les situations possibles avec un podium vide et 3 animaux sur l'autre podium
     */
    private void creerCartePodiumVide() {
        this.creerSituationsPodiumBleuVide(new Elephant(), new Ours(),      new Lion());
        this.creerSituationsPodiumBleuVide(new Elephant(), new Lion(),      new Ours());
        this.creerSituationsPodiumBleuVide(new Ours(),     new Lion(),      new Elephant());
        this.creerSituationsPodiumBleuVide(new Ours(),     new Elephant(),  new Lion());
        this.creerSituationsPodiumBleuVide(new Lion(),     new Ours(),      new Elephant());
        this.creerSituationsPodiumBleuVide(new Lion(),     new Elephant(),  new Ours());

        this.creerSituationsPodiumRougeVide(new Elephant(), new Ours(),      new Lion());
        this.creerSituationsPodiumRougeVide(new Elephant(), new Lion(),      new Ours());
        this.creerSituationsPodiumRougeVide(new Ours(),     new Lion(),      new Elephant());
        this.creerSituationsPodiumRougeVide(new Ours(),     new Elephant(),  new Lion());
        this.creerSituationsPodiumRougeVide(new Lion(),     new Ours(),      new Elephant());
        this.creerSituationsPodiumRougeVide(new Lion(),     new Elephant(),  new Ours());
    }

    /**
     * @brief Crée toutes les situations possibles avec un podium contenant 1 animal et 2 animaux sur l'autre podium
     */
    private void creerCartePodium1Animal() {
        this.creerSituationsPodiumBleu1Animal(new Elephant(), new Ours(), new Lion());
        this.creerSituationsPodiumBleu1Animal(new Elephant(), new Lion(), new Ours());
        this.creerSituationsPodiumBleu1Animal(new Lion(), new Elephant(), new Ours());
        this.creerSituationsPodiumBleu1Animal(new Lion(), new Ours(), new Elephant());
        this.creerSituationsPodiumBleu1Animal(new Ours(), new Lion(), new Elephant());
        this.creerSituationsPodiumBleu1Animal(new Ours(), new Elephant(), new Lion());

        this.creerSituationsPodiumRouge1Animal(new Elephant(), new Ours(), new Lion());
        this.creerSituationsPodiumRouge1Animal(new Elephant(), new Lion(), new Ours());
        this.creerSituationsPodiumRouge1Animal(new Lion(), new Elephant(), new Ours());
        this.creerSituationsPodiumRouge1Animal(new Lion(), new Ours(), new Elephant());
        this.creerSituationsPodiumRouge1Animal(new Ours(), new Lion(), new Elephant());
        this.creerSituationsPodiumRouge1Animal(new Ours(), new Elephant(), new Lion());
    }

    /**
     * Crée une situation avec le podium bleu vide
     * @param animal1 : animal en haut du podium
     * @param animal2 : animal au milieu du podium
     * @param animal3 : animal en bas du podium
     * @see creerCartePodiumVide pour son utilisation
     */
    private void creerSituationsPodiumBleuVide(Animal animal1, Animal animal2, Animal animal3) {
        Bleu podiumBleu = new Bleu("BLEU");
        Rouge podiumRouge = new Rouge("ROUGE");
        this.ajoute3AnimauxAuPodium(podiumRouge,animal1, animal2, animal3);
        this.situations.add(new Situation(podiumBleu, podiumRouge));
    }

    /**
     * Crée une situation avec le podium rouge vide
     * @param animal1 : animal en haut du podium
     * @param animal2 : animal au milieu du podium
     * @param animal3 : animal en bas du podium
     * @see creerCartePodiumVide pour son utilisation
     */
    private void creerSituationsPodiumRougeVide(Animal animal1, Animal animal2, Animal animal3) {
        Bleu podiumBleu = new Bleu("BLEU");
        Rouge podiumRouge = new Rouge("ROUGE");
        this.ajoute3AnimauxAuPodium(podiumBleu,animal1, animal2, animal3);
        this.situations.add(new Situation(podiumBleu, podiumRouge));
    }

    /**
     * @brief Permet d'ajouter 3 animaux sur un podium donné en paramètre
     * @param podium : Podium qui contiendra les 3 animaux reçus en paramètres
     * @param animal1 : animal en haut du podium
     * @param animal2 : animal au milieu du podium
     * @param animal3 : animal en bas du podium
     */
    private void ajoute3AnimauxAuPodium(Podium podium, Animal animal1, Animal animal2, Animal animal3) {
        podium.ajouteAnimal(animal1);
        podium.ajouteAnimal(animal2);
        podium.ajouteAnimal(animal3);
    }

    /**
     * @brief Crée une situation avec 1 animal sur le podium bleu
     * @param animalPodiumBleu : animal sur le podium bleu
     * @param animalPodiumRouge1 : animal au sommet du podium rouge
     * @param animalPodiumRouge2: animal en bas du podium rouge
     */
    private void creerSituationsPodiumBleu1Animal(Animal animalPodiumBleu, Animal animalPodiumRouge1, Animal animalPodiumRouge2) {
        Bleu podiumBleu = new Bleu("BLEU");
        podiumBleu.ajouteAnimal(animalPodiumBleu);

        Rouge podiumRouge = new Rouge("ROUGE");
        podiumRouge.ajouteAnimal(animalPodiumRouge1);
        podiumRouge.ajouteAnimal(animalPodiumRouge2);

        this.situations.add(new Situation(podiumBleu, podiumRouge));
    }

    /**
     * @brief Crée une situation avec 1 animal sur le podium rouge
     * @param animalPodiumRouge : animal sur le podium rouge
     * @param animalPodiumBleu1 : animal au sommet du podium bleu
     * @param animalPodiumBleu2: animal en bas du podium bleu
     */
    private void creerSituationsPodiumRouge1Animal(Animal animalPodiumRouge, Animal animalPodiumBleu1, Animal animalPodiumBleu2) {
        Rouge podiumRouge = new Rouge("ROUGE");
        podiumRouge.ajouteAnimal(animalPodiumRouge);

        Bleu podiumBleu = new Bleu("BLEU");
        podiumBleu.ajouteAnimal(animalPodiumBleu1);
        podiumBleu.ajouteAnimal(animalPodiumBleu2);

        this.situations.add(new Situation(podiumBleu, podiumRouge));
    }
}
