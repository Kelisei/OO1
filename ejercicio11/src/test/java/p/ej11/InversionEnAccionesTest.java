package p.ej11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

public class InversionEnAccionesTest {

	private InversionEnAcciones inversion;

	@BeforeEach
	void setUp() throws Exception {
		inversion = new InversionEnAcciones("AAPL", 10, 300d);
	}

	@Test
	void testValorActual() {
		assertEquals(3000, inversion.valorActual());
	}
}
