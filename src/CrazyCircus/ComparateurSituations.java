package CrazyCircus;

import CrazyCircus.Animal.Animal;

import java.util.ArrayList;

public class ComparateurSituations {
    private Situation actuelle;
    private Situation souhaitee;

    // Constructeur d'un comparateur de situations
    public ComparateurSituations(Situation actuelle, Situation souhaitee) {
        this.actuelle = actuelle;
        this.souhaitee = souhaitee;
    }

    /**
     * @brief Permet de comparer 2 situations
     * @return true si les situations sont identiques, false sinon
     */
    public boolean situationsSontIdentiques() {
        return this.actuelle.recupererPodiumBleu().toString().equals(this.souhaitee.recupererPodiumBleu().toString())
            && this.actuelle.recupererPodiumRouge().toString().equals(this.souhaitee.recupererPodiumRouge().toString());
    }
}
