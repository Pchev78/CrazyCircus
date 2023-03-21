package CrazyCircus.tests;

import CrazyCircus.Animal.Animal;
import CrazyCircus.Animal.Lion;
import CrazyCircus.Animal.Ours;
import CrazyCircus.Animal.Elephant;
import CrazyCircus.Ordres;
import CrazyCircus.Podium.Bleu;
import CrazyCircus.Podium.Rouge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import CrazyCircus.Situation;

import java.util.ArrayList;

class SituationTest {
    Bleu podiumBleu;
    Rouge podiumRouge;
    Situation situation;

    @BeforeEach
    void setUp() {
        Lion lion = new Lion();
        Ours ours = new Ours();
        Elephant elephant = new Elephant();

        podiumBleu = new Bleu("BLEU");
        podiumBleu.ajouteAnimal(lion);
        podiumBleu.ajouteAnimal(ours);

        podiumRouge = new Rouge("ROUGE");
        podiumRouge.ajouteAnimal(elephant);

        situation = new Situation(podiumBleu, podiumRouge);
    }

    @Test
    void executerOrdreKI() {
        ArrayList<Ordres> ordres = new ArrayList<Ordres>();
        ordres.add(Ordres.KI);

        situation.executerOrdres(ordres);

        ArrayList<Animal> animauxSurPodiumBleu = podiumBleu.recupererAnimaux();
        assertEquals("OURS", animauxSurPodiumBleu.get(0).recupereNom());
        ArrayList<Animal> animauxSurPodiumRouge = podiumRouge.recupererAnimaux();
        assertEquals("LION", animauxSurPodiumRouge.get(0).recupereNom());
        assertEquals("ELEPHANT", animauxSurPodiumRouge.get(1).recupereNom());
    }

    @Test
    void executerOrdreLO() {
        ArrayList<Ordres> ordres = new ArrayList<Ordres>();
        ordres.add(Ordres.LO);

        situation.executerOrdres(ordres);

        ArrayList<Animal> animauxSurPodiumBleu = podiumBleu.recupererAnimaux();
        assertEquals("ELEPHANT", animauxSurPodiumBleu.get(0).recupereNom());
        assertEquals("LION", animauxSurPodiumBleu.get(1).recupereNom());
        assertEquals("OURS", animauxSurPodiumBleu.get(2).recupereNom());
    }

    @Test
    void executerOrdreSO() {
        ArrayList<Ordres> ordres = new ArrayList<Ordres>();
        ordres.add(Ordres.SO);

        situation.executerOrdres(ordres);

        ArrayList<Animal> animauxSurPodiumBleu = podiumBleu.recupererAnimaux();
        assertEquals("ELEPHANT", animauxSurPodiumBleu.get(0).recupereNom());
        assertEquals("OURS", animauxSurPodiumBleu.get(1).recupereNom());
        ArrayList<Animal> animauxSurPodiumRouge = podiumRouge.recupererAnimaux();
        assertEquals("LION", animauxSurPodiumRouge.get(0).recupereNom());
    }

    @Test
    void executerOrdreNI() {
        ArrayList<Ordres> ordres = new ArrayList<Ordres>();
        ordres.add(Ordres.NI);

        situation.executerOrdres(ordres);

        ArrayList<Animal> animauxSurPodiumBleu = podiumBleu.recupererAnimaux();
        assertEquals("OURS", animauxSurPodiumBleu.get(0).recupereNom());
        assertEquals("LION", animauxSurPodiumBleu.get(1).recupereNom());
        ArrayList<Animal> animauxSurPodiumRouge = podiumRouge.recupererAnimaux();
        assertEquals("ELEPHANT", animauxSurPodiumRouge.get(0).recupereNom());
    }

    @Test
    void executerOrdreMA() {
        ArrayList<Ordres> ordres = new ArrayList<Ordres>();
        ordres.add(Ordres.MA);

        situation.executerOrdres(ordres);

        ArrayList<Animal> animauxSurPodiumBleu = podiumBleu.recupererAnimaux();
        assertEquals("LION", animauxSurPodiumBleu.get(0).recupereNom());
        assertEquals("OURS", animauxSurPodiumBleu.get(1).recupereNom());
        ArrayList<Animal> animauxSurPodiumRouge = podiumRouge.recupererAnimaux();
        assertEquals("ELEPHANT", animauxSurPodiumRouge.get(0).recupereNom());
    }
    @Test
    void elephantSurPodiumBleuOursLionSurPodiumRouge() {
        ArrayList<Ordres> ordres = new ArrayList<Ordres>();
        ordres.add(Ordres.KI);
        ordres.add(Ordres.KI);
        ordres.add(Ordres.MA);
        ordres.add(Ordres.LO);

        situation.executerOrdres(ordres);

        ArrayList<Animal> animauxSurPodiumRouge = podiumRouge.recupererAnimaux();
        ArrayList<Animal> animauxSurPodiumBleu = podiumBleu.recupererAnimaux();
        assertEquals(1, animauxSurPodiumBleu.size());
        assertEquals("ELEPHANT", animauxSurPodiumBleu.get(0).recupereNom());
        assertEquals(2, animauxSurPodiumRouge.size());
        assertEquals("OURS", animauxSurPodiumRouge.get(0).recupereNom());
        assertEquals("LION", animauxSurPodiumRouge.get(1).recupereNom());
    }

    @Test
    void oursElephantSurPodiumBleuLionSurPodiumRouge() {
        ArrayList<Ordres> ordres = new ArrayList<Ordres>();
        ordres.add(Ordres.SO);
        ordres.add(Ordres.NI);

        situation.executerOrdres(ordres);

        ArrayList<Animal> animauxSurPodiumRouge = podiumRouge.recupererAnimaux();
        ArrayList<Animal> animauxSurPodiumBleu = podiumBleu.recupererAnimaux();
        assertEquals(2, animauxSurPodiumBleu.size());
        assertEquals("OURS", animauxSurPodiumBleu.get(0).recupereNom());
        assertEquals("ELEPHANT", animauxSurPodiumBleu.get(1).recupereNom());
        assertEquals(1, animauxSurPodiumRouge.size());
        assertEquals("LION", animauxSurPodiumRouge.get(0).recupereNom());
    }

    @Test
    void elephantLionOursSurPodiumRouge() {
        ArrayList<Ordres> ordres = new ArrayList<Ordres>();
        ordres.add(Ordres.SO);
        ordres.add(Ordres.NI);
        ordres.add(Ordres.KI);
        ordres.add(Ordres.MA);
        ordres.add(Ordres.KI);

        situation.executerOrdres(ordres);

        ArrayList<Animal> animauxSurPodiumRouge = podiumRouge.recupererAnimaux();
        ArrayList<Animal> animauxSurPodiumBleu = podiumBleu.recupererAnimaux();
        assertEquals(0, animauxSurPodiumBleu.size());
        assertEquals(3, animauxSurPodiumRouge.size());
        assertEquals("ELEPHANT", animauxSurPodiumRouge.get(0).recupereNom());
        assertEquals("LION", animauxSurPodiumRouge.get(1).recupereNom());
        assertEquals("OURS", animauxSurPodiumRouge.get(2).recupereNom());
    }
}