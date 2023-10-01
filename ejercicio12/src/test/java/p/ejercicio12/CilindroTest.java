package p.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CilindroTest {

    @Test
    public void testGetVolumen() {
        Cilindro cilindro = new Cilindro("Acero", "Azul", 2.0, 5.0);
        assertEquals(62.832, cilindro.getVolumen(), 0.001);
    }

    @Test
    public void testGetSuperficie() {
        Cilindro cilindro = new Cilindro("Plástico", "Verde", 3.0, 8.0);
        assertEquals(207.34511513692635, cilindro.getSuperficie(), 0.001);
    }
}
