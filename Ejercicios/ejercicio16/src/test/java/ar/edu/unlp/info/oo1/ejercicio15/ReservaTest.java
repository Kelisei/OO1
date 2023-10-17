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
	
	private Reserva reservaEstricta;
	private Reserva reservaFlexible;
	private Reserva reservaModerada;
	
	private Propiedad propiedadEstricta;
	private Propiedad propiedadFlexible;
	private Propiedad propiedadModerada;
	
	@BeforeEach
	void setUp() {
		
		Politica estricta = new Estricta();
		Politica flexible = new Flexible();
		Politica moderada = new Moderada();
		Usuario dueño = new Usuario("Dueño", "", "");
		
		inquilino = new Usuario("Goku", "", "");
		propiedad = new Propiedad(dueño, "La Casona", 4000d, "373 e/ 2 y 24", moderada);
		reservaPasada = new Reserva(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11), propiedad, inquilino);
		reservaDespues = new Reserva(LocalDate.now().plusDays(2), LocalDate.now().plusDays(4), propiedad, inquilino);
		reservaSinDuracion = new Reserva(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 10), propiedad, inquilino);

		
		propiedadEstricta = new Propiedad(dueño, "La Casona", 1000d, "373 e/ 2 y 24", estricta);
		propiedadFlexible = new Propiedad(dueño, "La Casona", 1000d, "373 e/ 2 y 24", flexible);
		propiedadModerada = new Propiedad(dueño, "La Casona", 1000d, "373 e/ 2 y 24", moderada);
		
		reservaEstricta = new Reserva(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11), propiedadEstricta, inquilino);
		reservaFlexible = new Reserva(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11), propiedadFlexible, inquilino);
		reservaModerada = new Reserva(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11), propiedadModerada, inquilino);
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
	@Test
	void testReembolsarConUnaSemanaDeAntelacion() {
		assertEquals(0, reservaEstricta.getPrecioReembolso(LocalDate.of(2023, 10, 3)));
		assertEquals(1000d, reservaFlexible.getPrecioReembolso(LocalDate.of(2023, 10, 3)));
		assertEquals(1000d, reservaModerada.getPrecioReembolso(LocalDate.of(2023, 10, 3)));
	}
	@Test
	void testReembolsarConDosDiasDeAntelacion() {
		assertEquals(0, reservaEstricta.getPrecioReembolso(LocalDate.of(2023, 10, 8)));
		assertEquals(1000d, reservaFlexible.getPrecioReembolso(LocalDate.of(2023, 10, 8)));
		assertEquals(500d, reservaModerada.getPrecioReembolso(LocalDate.of(2023, 10, 8)));
	}
	@Test
	void testReembolsarDespues() {
		assertEquals(0, reservaEstricta.getPrecioReembolso(LocalDate.of(2023, 10, 11)));
		assertEquals(0, reservaFlexible.getPrecioReembolso(LocalDate.of(2023, 10, 11)));
		assertEquals(0, reservaModerada.getPrecioReembolso(LocalDate.of(2023, 10, 11)));
	}
}
