package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	private Reserva reservaPasada;
	private Reserva reservaDespues;
	private Reserva reservaSinDuracion;
	private Propiedad propiedad;
	private Usuario inquilino;
	
	@BeforeEach
	void setUp() {
		inquilino = new Usuario("Goku", "", "");
		propiedad = new Propiedad(new Usuario("Dueño", "", ""), "La Casona", 4000d, "373 e/ 2 y 24");
		reservaPasada = new Reserva(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11), propiedad, inquilino);
		reservaDespues = new Reserva(LocalDate.now().plusDays(2), LocalDate.now().plusDays(4), propiedad, inquilino);
		reservaSinDuracion = new Reserva(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 10), propiedad, inquilino);
	}
	@Test
	void testPrecioTotal() {
		assertEquals(8000, reservaDespues.precioTotal());
	}
	@Test
	void testPrecioTotalSinDuracion() {
		assertEquals(0, reservaSinDuracion.precioTotal());
	}
	@Test
	void testEsDespuesReservaPasada() {
		assertFalse(reservaPasada.esDespues());
	}
	@Test
	void testEsDespuesReservaFutura() {
		assertTrue(reservaDespues.esDespues());
	}
}
