package ar.edu.unlp.info.oo1.ej18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PermanenteTest {
	private PlantaPermanente c1;
	private PlantaPermanente c2;
	private Empleado e1;
	private Empleado e2;
	
	@BeforeEach
	public void setUp() {
		e1 = new Empleado("nombre", "apellido", "Cuil", LocalDate.of(2003, 1, 1), true, true,
				LocalDate.of(2023, 1, 1));
		e2 = new Empleado("nombre", "apellido", "Cuil", LocalDate.of(2003, 1, 1), false, false,
				LocalDate.of(2023, 1, 1));
		
		c1 = new PlantaPermanente(LocalDate.of(2024, 1, 1), e1, 1.0, 1.0, 1.0);
		c2 = new PlantaPermanente(LocalDate.of(2023, 1, 2), e2, 1.0, 1.0, 1.0);
	}
	@Test
	public void calcularMontoTest() {
		assertEquals(3.0, c1.calcularMonto());
	}
	@Test
	public void calcularMontoSinHacerseCargoTest() {
		assertEquals(1.0, c2.calcularMonto());
	}
	@Test
	public void aniosCumplidosTest() {
		assertEquals(0, c1.aniosCumplidos());
		assertEquals(0, c2.aniosCumplidos());
	}
}
