package oo1.ejercicio9;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CajaDeAhorroTest {
	
	private CajaDeAhorro cajaDeAhorro;
	@BeforeEach
	void setUp() throws Exception {
		cajaDeAhorro = new CajaDeAhorro();
	}
	@Test
	void testConstructor() {
		assertEquals(0,cajaDeAhorro.getSaldo());
	}
	@Test
	void testExtraerYDepositar() {
		//Depositamos 980
		cajaDeAhorro.depositar(1000);
		assertEquals(980, cajaDeAhorro.getSaldo());
		//Extraemos 500 (510 con 2%)
		cajaDeAhorro.extraer(500);
		assertEquals(470, cajaDeAhorro.getSaldo());
	}
	@Test
	void testExtraerVacio() {
		cajaDeAhorro.extraer(1000);
		assertEquals(0, cajaDeAhorro.getSaldo());
	}
	@Test
	void testTransferir() {
		CajaDeAhorro batiCaja = new CajaDeAhorro();
		cajaDeAhorro.depositar(2000);
		cajaDeAhorro.transferirACuenta(1900, batiCaja);
		assertEquals(22, cajaDeAhorro.getSaldo());
		assertEquals(1899.24, batiCaja.getSaldo());
	}
	@Test
	void testTransferirVacio() {
		CajaDeAhorro batiCaja = new CajaDeAhorro();
		cajaDeAhorro.transferirACuenta(1900, batiCaja);
		assertEquals(0, cajaDeAhorro.getSaldo());
		assertEquals(0, batiCaja.getSaldo());
	}
}
