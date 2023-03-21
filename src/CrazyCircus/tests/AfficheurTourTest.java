package CrazyCircus.tests;

import CrazyCircus.AfficheurTour;
import CrazyCircus.Animal.Elephant;
import CrazyCircus.Animal.Lion;
import CrazyCircus.Animal.Ours;
import CrazyCircus.Joueur;
import CrazyCircus.Podium.Bleu;
import CrazyCircus.Podium.Rouge;
import CrazyCircus.Situation;
import CrazyCircus.Tour;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AfficheurTourTest {
    @Test
    void afficher1() {
        Bleu podiumDepartBleu = new Bleu("BLEU");
        podiumDepartBleu.ajouteAnimal(new Ours());
        podiumDepartBleu.ajouteAnimal(new Lion());
        Rouge podiumDepartRouge = new Rouge("ROUGE");
        podiumDepartRouge.ajouteAnimal(new Elephant());
        Situation situationDepart = new Situation(podiumDepartBleu, podiumDepartRouge);

        Bleu podiumArriveBleu = new Bleu("BLEU");
        podiumArriveBleu.ajouteAnimal(new Lion());
        podiumArriveBleu.ajouteAnimal(new Elephant());
        Rouge podiumArriveRouge = new Rouge("ROUGE");
        podiumArriveRouge.ajouteAnimal(new Ours());
        Situation situationArrivee = new Situation(podiumArriveBleu, podiumArriveRouge);
        Joueur joueur = new Joueur("PC");

        Tour tour = new Tour(situationDepart, situationArrivee, joueur);

        AfficheurTour afficheur = new AfficheurTour(tour);

        afficheur.afficherAvecAide();

        assertTrue(true);
    }

}