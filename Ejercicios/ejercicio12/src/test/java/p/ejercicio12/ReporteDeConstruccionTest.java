package p.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {

    private ReporteDeConstruccion reporte;

    @BeforeEach
    public void setUp() throws Exception{
        reporte = new ReporteDeConstruccion();
        reporte.addPieza(new PrismaRectangular("Madera", "Marrón", 5, 3, 4));
        reporte.addPieza(new PrismaRectangular("Metal", "Plateado", 6, 4, 2));
    }

    @Test
    public void testVolumenDeMaterial() {
        assertEquals(60.0, reporte.volumenDeMaterial("Madera"), 0.001);
    }

    @Test
    public void testSuperficieDeColor() {
        assertEquals(88.0, reporte.superficieDeColor("Plateado"), 0.001);
    }
}
