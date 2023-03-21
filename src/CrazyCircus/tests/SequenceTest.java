package CrazyCircus.tests;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import CrazyCircus.Sequence;
import CrazyCircus.Ordres;

class SequenceTest {

    @Test
    void recupereOrdre() {
        Sequence sequence = new Sequence("KIMALONI");

        ArrayList<Ordres> ordresExpecte = new ArrayList<>();
        ordresExpecte.add(Ordres.KI);
        ordresExpecte.add(Ordres.MA);
        ordresExpecte.add(Ordres.LO);
        ordresExpecte.add(Ordres.NI);

        ArrayList<Ordres> ordresActuel = sequence.recupereOrdre();

        assertEquals(ordresExpecte, ordresActuel);
    }
}
