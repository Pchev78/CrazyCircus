package CrazyCircus.tests;

import CrazyCircus.Animal.Elephant;
import CrazyCircus.Animal.Lion;
import CrazyCircus.Animal.Ours;
import CrazyCircus.Joueur;
import CrazyCircus.Podium.Bleu;
import CrazyCircus.Podium.Rouge;
import CrazyCircus.Sequence;
import CrazyCircus.Situation;
import CrazyCircus.Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TourTest {

    Bleu podiumBleu;
    Rouge podiumRouge;
    Situation situation;

    @BeforeEach
    void setUp() {
        podiumBleu = new Bleu("BLEU");
        podiumBleu.ajouteAnimal(new Lion());
        podiumBleu.ajouteAnimal(new Ours());

        podiumRouge = new Rouge("ROUGE");
        podiumRouge.ajouteAnimal(new Elephant());

        situation = new Situation(podiumBleu, podiumRouge);
    }
/*

    @Test
    void deplaceElephantSurPileBleu() {
        Rouge podiumRougeAttendu = new Rouge("ROUGE");
        Bleu podiumBleuAttendu = new Bleu("BLEU");
        podiumBleuAttendu.ajouteAnimal(new Elephant());
        podiumBleuAttendu.ajouteAnimal(new Lion());
        podiumBleuAttendu.ajouteAnimal(new Ours());
        Situation situationAttendue = new Situation(podiumBleuAttendu, podiumRougeAttendu);
        Joueur joueur = new Joueur("PC");
        joueur.creerSequence(new Sequence("LO"));
        Tour tour = new Tour(situation, situationAttendue, joueur);
       boolean joueurAreussi = false;

        try {
            joueurAreussi = tour.lancer();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        assertTrue(joueurAreussi);
    }
*/

    @Test
    void deplaceLionSurPileBleuEtMettreElephantAuSommet() {
        Rouge podiumRougeAttendu = new Rouge("ROUGE");
        Bleu podiumBleuAttendu = new Bleu("BLEU");
        podiumRougeAttendu.ajouteAnimal(new Elephant());
        podiumRougeAttendu.ajouteAnimal(new Lion());
        podiumBleuAttendu.ajouteAnimal(new Ours());
        Situation situationAttendue = new Situation(podiumBleuAttendu, podiumRougeAttendu);
        Joueur joueur = new Joueur("PC");
        joueur.creerSequence(new Sequence("KIMA"));
        Tour tour = new Tour(situation, situationAttendue, joueur);

//        System.out.println(tour);

        try {
            System.out.println(tour);
            tour.lancer();
            //System.out.println(tour);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        assertEquals(1, joueur.recupererPoints());
    }
}