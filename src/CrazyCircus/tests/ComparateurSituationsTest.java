package CrazyCircus.tests;

import CrazyCircus.Animal.Elephant;
import CrazyCircus.Animal.Lion;
import CrazyCircus.Animal.Ours;
import CrazyCircus.ComparateurSituations;
import CrazyCircus.Podium.Bleu;
import CrazyCircus.Podium.Rouge;
import CrazyCircus.Situation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparateurSituationsTest {
    Bleu podiumBleu;
    Rouge podiumRouge;
    Bleu podiumBleuSouhaite;
    Rouge podiumRougeSouhaite;

    @BeforeEach
    void setUp() {
        podiumBleu = new Bleu("BLEU");
        podiumRouge = new Rouge("ROUGE");
        podiumBleuSouhaite = new Bleu("BLEU");
        podiumRougeSouhaite = new Rouge("ROUGE");
    }
    @Test
    void situationsNeSontPasIdentiques() {
        podiumBleu.ajouteAnimal(new Lion());
        podiumBleu.ajouteAnimal(new Ours());
        podiumRouge.ajouteAnimal(new Elephant());
        Situation actuelle = new Situation(podiumBleu, podiumRouge);
        podiumBleuSouhaite.ajouteAnimal(new Elephant());
        podiumRougeSouhaite.ajouteAnimal(new Ours());
        podiumRougeSouhaite.ajouteAnimal(new Lion());
        Situation souhaitee = new Situation(podiumBleuSouhaite, podiumRougeSouhaite);
        ComparateurSituations comparateur = new ComparateurSituations(actuelle, souhaitee);

        boolean situationsSontIdentiques = comparateur.situationsSontIdentiques();

        assertFalse(situationsSontIdentiques);
    }

    @Test
    void ordreNEstPasIdentique () {
        podiumBleu.ajouteAnimal(new Elephant());
        podiumBleu.ajouteAnimal(new Lion());
        podiumRouge.ajouteAnimal(new Ours());
        Situation actuelle = new Situation(podiumBleu, podiumRouge);
        podiumBleuSouhaite.ajouteAnimal(new Lion());
        podiumBleuSouhaite.ajouteAnimal(new Elephant());
        podiumRougeSouhaite.ajouteAnimal(new Ours());
        Situation souhaitee = new Situation(podiumBleuSouhaite, podiumRougeSouhaite);
        ComparateurSituations comparateur = new ComparateurSituations(actuelle, souhaitee);

        boolean situationsSontIdentiques = comparateur.situationsSontIdentiques();

        assertFalse(situationsSontIdentiques);
    }
    @Test
    void situationsSontIdentiques() {
        podiumBleu.ajouteAnimal(new Elephant());
        podiumRouge.ajouteAnimal(new Ours());
        podiumRouge.ajouteAnimal(new Lion());
        Situation actuelle = new Situation(podiumBleu, podiumRouge);
        podiumBleuSouhaite.ajouteAnimal(new Elephant());
        podiumRougeSouhaite.ajouteAnimal(new Ours());
        podiumRougeSouhaite.ajouteAnimal(new Lion());
        Situation souhaitee = new Situation(podiumBleuSouhaite, podiumRougeSouhaite);
        ComparateurSituations comparateur = new ComparateurSituations(actuelle, souhaitee);

        boolean situationsSontIdentiques = comparateur.situationsSontIdentiques();

        assertTrue(situationsSontIdentiques);
    }
}