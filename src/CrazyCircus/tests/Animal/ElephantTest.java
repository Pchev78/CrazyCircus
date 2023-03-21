package CrazyCircus.tests.Animal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import CrazyCircus.Animal.Elephant;

import static org.junit.jupiter.api.Assertions.*;

class ElephantTest {
    @Test
    void creeElephant(){
        Elephant elephant = new Elephant();

        assertEquals("ELEPHANT", elephant.recupereNom());
    }
}