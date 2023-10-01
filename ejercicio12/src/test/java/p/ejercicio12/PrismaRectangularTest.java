package p.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PrismaRectangularTest {
	
    @Test
    public void testGetVolumen() {
        PrismaRectangular prisma = new PrismaRectangular("Madera", "Marrón", 5, 3, 4);
        assertEquals(60.0, prisma.getVolumen(), 0.001); // Comprueba que el volumen es correcto
    }

    @Test
    public void testGetSuperficie() {
        PrismaRectangular prisma = new PrismaRectangular("Metal", "Plateado", 6, 4, 2);
        assertEquals(88.0, prisma.getSuperficie(), 0.001); // Comprueba que la superficie es correcta
    }
}