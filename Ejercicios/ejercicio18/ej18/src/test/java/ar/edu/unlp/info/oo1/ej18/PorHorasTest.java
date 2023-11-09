package ar.edu.unlp.info.oo1.ej18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PorHorasTest {
	private PorHoras c3;
	private PorHoras c4;
	private Empleado e1;
	private Empleado e2;
	
	@BeforeEach
	public void setUp() {
		e1 = new Empleado("nombre", "apellido", "Cuil", LocalDate.of(2003, 1, 1), true, true,
				LocalDate.of(2023, 1, 1));
		e2 = new Empleado("nombre", "apellido", "Cuil", LocalDate.of(2003, 1, 1), false, false,
				LocalDate.of(2023, 1, 1));
		
		c3 = new PorHoras(LocalDate.of(2022, 1, 3), e1, LocalDate.of(2023, 1, 5), 1.0, 1);
		c4 = new PorHoras(LocalDate.of(2024, 1, 4), e2, LocalDate.of(2024, 1, 6), 1.0, 1);
	}
	@Test
	public void isVencidoPorHorasTest() {
		assertFalse(c4.isVencido());
		assertTrue(c3.isVencido());
	}
	@Test
	public void calcularMontoTest() {
		assertEquals(1, c3.calcularMonto());
		assertEquals(1, c4.calcularMonto());
	}
	@Test
	public void aniosCumplidosTest() {
		assertEquals(1, c3.aniosCumplidos());
		assertEquals(0, c4.aniosCumplidos());
	}
}
