package p.ej11;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InversorTest {
	private Inversor i1;
	private Inversor i2;
	private Inversion acciones;
	private Inversion fijo;
	@BeforeEach
	void setUp() throws Exception {
		i1 = new Inversor("Goku");
		i2 = new Inversor("Vegeta");
		fijo=new PlazoFijo(4000, 75);
		acciones=new InversionEnAcciones("AAPL", 10, 300d);
	}
	
	@Test
	void agregarInversion() {
		i1.agregarInversion(fijo);
		assertEquals(i1.getSizeInversiones(), 1);
		i1.agregarInversion(acciones);
		assertEquals(i1.getSizeInversiones(), 2);
		assertEquals(i2.getSizeInversiones(), 0);
	}
	@Test
	void valorActual() {
		i1.agregarInversion(fijo);
		i1.agregarInversion(acciones);
		assertEquals(i1.valorActual(), 7000);
		assertEquals(i2.valorActual(), 0);
	}
}
