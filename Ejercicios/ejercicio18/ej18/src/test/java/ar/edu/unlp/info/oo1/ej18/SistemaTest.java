package ar.edu.unlp.info.oo1.ej18;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	Sistema s;
	@BeforeEach
	public void setUp() {
		s = new Sistema();
		s.darDeAltaEmpleado("Juan","Diaz","123",LocalDate.of(2002, 10, 24),false, true, LocalDate.of(2004, 1, 1));
	}
	@Test
	public void testBuscarEmpleado() {
		assertNotNull(s.buscarEmpleado("123"));
	}
	@Test
	public void testBuscarEmpleadoNoTa() {
		assertNull(s.buscarEmpleado("12"));
	}
}
