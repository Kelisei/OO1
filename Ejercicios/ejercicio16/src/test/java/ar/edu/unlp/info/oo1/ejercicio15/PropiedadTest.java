package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {
	private Reserva reserva;
	private Propiedad propiedadSinReservas;
	private Propiedad propiedad;
	private Usuario inquilino;
	private DateLapse periodo1;
	private DateLapse periodo2;
	private DateLapse periodo3;
	private DateLapse periodo4;
	private DateLapse periodo5;
	@BeforeEach
	void setUp() {
		inquilino = new Usuario("Goku", "", "");
		propiedad = new Propiedad(new Usuario("Dueño", "", ""), "La Casona", 4000d, "373 e/ 2 y 24", new Moderada());
		propiedadSinReservas = new Propiedad(new Usuario("Dueño2", "", ""), "La Casona", 4000d, "373 e/ 2 y 24", new Moderada());
		
		periodo1 = new DateLapse(LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 10));
		periodo2 = new DateLapse(LocalDate.of(2023, 10, 13), LocalDate.of(2023, 10, 12));
		periodo3 = new DateLapse(LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 8));
		periodo4 = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 10));
		periodo5 = new DateLapse(LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 11));
		
		reserva = new Reserva(periodo1.getFrom(), periodo1.getTo(), propiedad, inquilino);
		propiedad.aniadirReserva(reserva);
		
	}
	@Test
	void testEstaLibreOverlap() {
		assertFalse(propiedad.estaLibre(periodo1));
	}
	@Test
	void testEstaLibreNoOverlap() {
		assertTrue(propiedad.estaLibre(periodo2));
		assertTrue(propiedad.estaLibre(periodo3));
	}
	@Test
	void testEstaLibreBorde() {
		assertFalse(propiedad.estaLibre(periodo4));
		assertFalse(propiedad.estaLibre(periodo5));
	}
	@Test
	void testGetPrecioReservasEnUnPeriodoConReservas() {
		assertEquals(4000d, propiedad.getPrecioReservasEnUnPeriodo(periodo1));
	}
	@Test
	void testGetPrecioReservasEnUnPeriodoSinReservas() {
		assertEquals(0, propiedad.getPrecioReservasEnUnPeriodo(periodo2));
	}
	@Test
	void testGetPrecioReservasEnUnPeriodoNingunaReservacion() {
		assertEquals(0, propiedadSinReservas.getPrecioReservasEnUnPeriodo(periodo3));
	}
}
