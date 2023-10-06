package p.ej11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
public class PlazoFijoTest {
	private PlazoFijo plazoFijo;
	@BeforeEach
	void setUp() throws Exception {
		plazoFijo = new PlazoFijo(100, 0.05);
	}
	@Test
	void testValorActual() {
		assertEquals(100,plazoFijo.valorActual());
	}
}
