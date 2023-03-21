package CrazyCircus.tests;

import CrazyCircus.Joueur;
import CrazyCircus.Partie;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PartieTest
{
    @Test
    void recupererJoueurs() throws Exception {
        Partie partie = new Partie("PC TC");
        partie.lancerPartie();

        ArrayList<Joueur> listDesJoueurs = partie.recupererJoueurs();

        assertEquals(2, listDesJoueurs.size());
        assertEquals("PC", listDesJoueurs.get(0).getIdentifiant());
        assertEquals("TC", listDesJoueurs.get(1).getIdentifiant());
    }

    @Test
    void testRecupererJoueurs() {
    }
}