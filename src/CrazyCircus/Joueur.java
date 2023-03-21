package CrazyCircus;

public class Joueur {
    // Initialiser les joueurs
    private String identifiant = "";
    private int points = 0;
    private boolean peutJouer = true; // Permet de déterminer si le joueur peut encore jouer pendant un tour ou non

    private Sequence sequence; // Séquence que le joueur aura saisi

    // Constructeur d'un joueur, prenant en paramètre son identifiant
    public Joueur(String identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * @brief Getter de l'identifiant d'un joueur
     * @return l'identifiant du joueur
     */
    public String getIdentifiant() {
        return this.identifiant;
    }

    /**
     * @brief Getter de la possibilité pour le joueur de jouer
     * @return true si le joueur peut jouer, false sinon
     */
    public boolean recupererPeutJouer() {
        return peutJouer;
    }

    /**
     * @brief Setter de peutJouer
     * @param peutJouer : indique si le joueur peut jouer ou non
     */
    public void nePeutPlusJouer () {
        this.peutJouer = false;
    }

    /**
     * @brief Getter des points
     * @return les points du joueur
     */
    public int recupererPoints() {
        return points;
    }

    /**
     * @brief Ajoute un point au joueur
     */
    public void augmenterPoints() {
        this.points ++;
    }

    /**
     * @brief Crée une séquence à partir de celle reçue en paramètre
     * @param sequence : séquence que l'on veut créer
     */
    public void creerSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    /**
     * @brief Getter de la séquence
     * @return la séquence du joueur
     */
    public Sequence recupererSequence() {
        return this.sequence;
    }
}