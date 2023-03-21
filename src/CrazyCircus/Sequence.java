package CrazyCircus;

import java.util.ArrayList;

public class Sequence {
    private String texte;
    private ArrayList<Ordres> ordres = new ArrayList<>(); // Ordres de la séquence
    private static final int LONGUEUR_ORDRE = 2; // Un ordre a une longueur de 2 caractères

    // Constructeur d'une séquence
    public Sequence(String texte) {
        this.texte = texte;
        this.creerDesOrdres();
    }

    /**
     * @brief Crée des ordres et les ajoute dans le tableau correspondant
     */
    private void creerDesOrdres() {
        String[] ordres = this.decoupeLaSequenceEnTableau();

        for (int i = 0; i < ordres.length; i++) {
            this.ajouteOrdre(ordres[i]);
        }
    }

    /**
     * @brief Permet de découper la séquence en un tableau de chaînes de caractères
     * @return les ordres sous forme de tableau de chaînes de caractères
     */
    private String[] decoupeLaSequenceEnTableau() {
        return this.texte.split("(?<=\\G.{" + LONGUEUR_ORDRE + "})");
    }

    /**
     * @brief Permet d'ajouter un ordre au tableau correspondant
     * @param ordre : l'ordre à ajouter
     */
    private void ajouteOrdre(String ordre) {
        if (ordre.equals("KI")) {
            this.ordres.add(Ordres.KI);
        } else if (ordre.equals("LO")) {
            this.ordres.add(Ordres.LO);
        }
        else if (ordre.equals("SO")) {
            this.ordres.add(Ordres.SO);
        }
        else if (ordre.equals("NI")) {
            this.ordres.add(Ordres.NI);
        }
        else if (ordre.equals("MA")) {
            this.ordres.add(Ordres.MA);
        }
    }

    /**
     * @brief Getter des ordres
     * @return les ordres de la séquence
     */
    public ArrayList<Ordres> recupereOrdre() {
        return this.ordres;
    }
}
