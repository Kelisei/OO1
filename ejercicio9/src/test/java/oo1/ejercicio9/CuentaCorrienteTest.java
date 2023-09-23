package oo1.ejercicio9;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CuentaCorrienteTest {

	private CuentaCorriente cuentaCorriente;
	@BeforeEach
	void setUp() throws Exception {
		cuentaCorriente = new CuentaCorriente();
	}
	@Test
	void testConstructor() {
		assertEquals(0,cuentaCorriente.getSaldo());
	}
	@Test
	void testDepositar() {
		cuentaCorriente.depositar(1000);
		assertEquals(1000, cuentaCorriente.getSaldo());
	}
	@Test
	void testExtraer() {
		cuentaCorriente.setDescubierto(1000);
		cuentaCorriente.setSaldo(1000);
		cuentaCorriente.extraer(2000);
		assertEquals(-1000, cuentaCorriente.getSaldo());
		cuentaCorriente.extraer(200);
		assertEquals(-1000, cuentaCorriente.getSaldo());
	}
	@Test
	void testExtraerVacio() {
		cuentaCorriente.extraer(1000);
		assertEquals(0, cuentaCorriente.getSaldo());
	}
	@Test
	void testTransferir() {
		CuentaCorriente batiCaja = new CuentaCorriente();
		cuentaCorriente.setSaldo(2000);
		cuentaCorriente.transferirACuenta(2000, batiCaja);
		assertEquals(0, cuentaCorriente.getSaldo());
		assertEquals(2000, batiCaja.getSaldo());
	}
	@Test
	void testTransferirVacio() {
		CuentaCorriente batiCaja = new CuentaCorriente();
		cuentaCorriente.transferirACuenta(1900, batiCaja);
		assertEquals(0, cuentaCorriente.getSaldo());
		assertEquals(0, batiCaja.getSaldo());
	}

}
