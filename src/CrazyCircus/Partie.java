package CrazyCircus;

import java.lang.reflect.Array;
import java.util.*;

public class Partie {

    private ArrayList<Joueur> joueurs = new ArrayList<>(); // Tableau contenant tous les joueurs d'une partie
    private static final int NOMBRE_TOURS = 12;
    private ArrayList<Integer> indexSituations = new ArrayList<>();
    // @TODO Créer une variable stockant les tours

    // Constructeur d'une partie, prenant en paramètres les joueurs de la partie
    public Partie(String joueurs) {
        this.creerJoueurs(joueurs);
    }

    /**
     * @brief Crée les joueurs et les ajoute danss le tableau les contenant
     * @param joueurs : les joueurs à ajouter
     */
    private void creerJoueurs(String joueurs) {
        String[] listJoueurs = this.decoupeJoueursEnTableau(joueurs);

        for (int i = 0; i < listJoueurs.length; i++) {
            this.ajouterJoueurParIdentifiant(listJoueurs[i]);
        }
    }

    /**
     * @brief Decoupe la chaîne de caractères reçue en paramètres pour pouvoir ajouter les joueurs dans un tableau
     * @param joueurs : la chaîne de caractères à découper
     * @return le tableau de chaînes de caractères des joueurs
     */
    private String[] decoupeJoueursEnTableau(String joueurs) {
        return joueurs.split("\\s+");
    }

    /**
     * @brief Permet d'ajouter un joueur avec son identifiant
     * @param identifiant : l'identifiant du joueur à ajouter
     */
    private void ajouterJoueurParIdentifiant(String identifiant) {
        Joueur joueur = new Joueur(identifiant);
        this.joueurs.add(joueur);
    }

    /**
     * @brief Getter des joueurs
     * @return les joueurs de la partie
     */
    public ArrayList<Joueur> recupererJoueurs() {
        return this.joueurs;
    }

    private void initialiserIndexSituations() {
        for (int i = 0; i < NOMBRE_TOURS*2; i++)
            this.indexSituations.add(i);
    }

    private int recupereIndexSituationsAleatoirement() {
        Random r = new Random();
        int max = this.indexSituations.size() - 1;
        int index = r.nextInt(max);
        this.indexSituations.remove(index);
        return index;
    }

    public void lancerPartie() throws Exception {
        Carte carte = new Carte();
        this.initialiserIndexSituations();
        for (int i = 0; i < this.NOMBRE_TOURS - 1; i++) {
            int indexSituationDepart = this.recupereIndexSituationsAleatoirement();
            Situation situationDepart = carte.recupererSituation(indexSituationDepart);
            int indexSituationArrivee = this.recupereIndexSituationsAleatoirement();
            Situation situationArrivee = carte.recupererSituation(indexSituationArrivee);

            for (int j = 0; j < this.joueurs.size(); j++) {
                // Demander à l'utilisateur de rentrer ses identifiants puis la séquence
                // Vérifier que l'utilisateur existe et peut jouer.
                // Si c'est le cas, lancer le tour
                System.out.println(this.joueurs.get(j).getIdentifiant() + ", merci d'entrer votre commande");
                Joueur joueur = this.lireJoueur();
                Tour tour = new Tour(situationDepart,situationArrivee, joueur);
                AfficheurTour afficheurTour = new AfficheurTour(tour);
                afficheurTour.afficherAvecAide();
                tour.lancer();
                ComparateurSituations comparateur = new ComparateurSituations(tour.recupereSituationDepart(),tour.recupereSituationArrivee());
                if (comparateur.situationsSontIdentiques()) {
                    joueur.augmenterPoints();
                    System.out.println("Bonne combinaison, vous gagnez 1 point");
                    break;
                }
                AfficheurTour afficherApresCoup = new AfficheurTour(tour);
                afficherApresCoup.afficher();
            }
        }
    }

    private Joueur lireJoueur() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String identifiantEtSequence = scanner.nextLine();
        String[] identifiantEtSequenceEnTableau = identifiantEtSequence.split("\\s+");
        String identifiant = identifiantEtSequenceEnTableau[0];
        String sequence = identifiantEtSequenceEnTableau[1];
        int indexJoueur = this.recupereIndexJoueurParIdentifiant(identifiant);
        Joueur joueur = this.joueurs.get(indexJoueur);
        joueur.creerSequence(new Sequence(sequence));
        return joueur;
    }

    private boolean joueurExisteOuNePeutPlusJouer(Joueur joueur) {
        for (Joueur joueurExistant : this.joueurs){
            if (joueur.getIdentifiant().equals(joueurExistant.getIdentifiant()) || joueur.recupererPeutJouer()) {
                return true;
            }
        }
        return false;
    }

    private int recupereIndexJoueurParIdentifiant(String identifiant) throws Exception {
        for(int i = 0; i < this.joueurs.size(); i++) {
            if (this.joueurs.get(i).getIdentifiant().equals(identifiant)) {
                return i;
            }
        }
        throw new Exception("Le joueur de cet identifiant n'existe pas");
    }
}
