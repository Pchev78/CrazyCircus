package CrazyCircus.tests;

import CrazyCircus.Carte;
import CrazyCircus.Situation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    @Test
    void recupererSituation() throws Exception {
        Carte carte = new Carte();
        Situation situation = carte.recupererSituation(0);
        String afficher = situation.recupererPodiumBleu().recupererNom();
        System.out.println(afficher);
    }

//    @Test
//    void supprimerSituation() {
//    }

//    @Test
//    void recupererTailleSituations() {
//    }
}