package p.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EsferaTest {
	
    @Test
    public void testGetVolumen() {
        Esfera esfera = new Esfera("Plástico", "Rojo", 2.0);
        assertEquals(33.510, esfera.getVolumen(), 0.001); 
    }

    @Test
    public void testGetSuperficie() {
        Esfera esfera = new Esfera("Acero", "Plateado", 3.0);
        assertEquals(113.097, esfera.getSuperficie(), 0.001);
    }
}