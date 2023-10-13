package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OOBnBTest {
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	private Reserva reserva4;
	private Reserva reserva5;
	private Reserva reserva6;
	private Reserva reserva7;
	private Reserva reservaFutura;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Propiedad propiedad3;
	private Usuario inquilino1;
	private Usuario inquilino2;
	private Usuario duenio1;
	private Usuario duenio2;
	private DateLapse periodo1;
	private DateLapse periodo2;
	private DateLapse periodo3;
	private DateLapse periodoFuturo;
	private OOBnB sistema;
	@BeforeEach
	void setUp() {
		sistema = new OOBnB();
		
		inquilino1 = sistema.aniadirUsuario("Jose Jacinto Rivera", "44.222.222", "371 e/ 2 y 24");
		inquilino2 = sistema.aniadirUsuario("Jacinto Jacinto Rivera", "43.222.222", "372 e/ 2 y 24");
		duenio1 = sistema.aniadirUsuario("Jose Jose Rivera", "42.222.222", "373 e/ 2 y 24");
		duenio2 = sistema.aniadirUsuario("Jacinto Jose Rivera", "41.222.222", "374 e/ 2 y 24");
		
		propiedad1 = sistema.aniadirPropiedad("La Casona", "Bien grande", 1, duenio1);
		propiedad2 = sistema.aniadirPropiedad("Procap", "Bing Chilling", 2, duenio2);
		propiedad3 = sistema.aniadirPropiedad("Sistedh", "Turkosone", 2, duenio2);
		
		periodo1 = new DateLapse(LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 10));
		periodo2 = new DateLapse(LocalDate.of(2023, 10, 13), LocalDate.of(2023, 10, 12));
		periodo3 = new DateLapse(LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 8));
		periodoFuturo = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(1));
		// No null
		reserva1 = sistema.aniadirReserva(periodo1.getFrom(), periodo1.getTo(), inquilino1, propiedad1);
		// Null
		reserva2 = sistema.aniadirReserva(periodo1.getFrom(), periodo1.getTo(), inquilino1, propiedad1);
		// No null
		reserva3 = sistema.aniadirReserva(periodo2.getFrom(), periodo2.getTo(), inquilino2, propiedad1);
		// No null
		reserva4 = sistema.aniadirReserva(periodo3.getFrom(), periodo3.getTo(), inquilino2, propiedad1);
		// No null
		reserva5 = sistema.aniadirReserva(periodo2.getFrom(), periodo2.getTo(), inquilino2, propiedad3);
		// No null
		reserva6 = sistema.aniadirReserva(periodo3.getFrom(), periodo3.getTo(), inquilino2, propiedad2);
		// No null
		reserva7 = sistema.aniadirReserva(periodo3.getFrom(), periodo3.getTo(), inquilino2, propiedad3);
		reservaFutura = sistema.aniadirReserva(periodoFuturo.getFrom(), periodoFuturo.getTo(), inquilino2, propiedad3);
	}
	@Test
	void testGetPropiedadesDisponibles() {
		//Que esten todas
		assertEquals(3, sistema.getPropiedadesDisponibles(LocalDate.of(2023, 12, 30), LocalDate.of(2023, 12, 30)).size());
		//En cierto periodo de tiempo
		assertEquals(2, sistema.getPropiedadesDisponibles(periodo1.getFrom(), periodo1.getTo()).size());
		//Todas alquiladas a la vez
		assertEquals(0, sistema.getPropiedadesDisponibles(periodo3.getFrom(), periodo3.getTo()).size());
	}

	@Test
	void testAniadirReserva() {
		assertNotNull(reserva1);
		assertNull(reserva2);
		assertNotNull(reserva3);
		assertNotNull(reserva4);
		assertNotNull(reserva5);
		assertNotNull(reserva6);
		assertNotNull(reserva7);
		assertEquals(1 , this.inquilino1.getReservas().size());
		assertEquals(6 , this.inquilino2.getReservas().size());
	}
	@Test
	void testEliminarReservaReservaPasada() {
		sistema.eliminarReserva(reserva3);
		assertEquals(6, inquilino2.getReservas().size());
	}
	@Test
	void testEliminarReservaFutura() {
		sistema.eliminarReserva(reservaFutura);
		assertEquals(5, inquilino2.getReservas().size());
	}

	@Test
	void testCalcularIngresosPropietarioDuenio1() {
		assertEquals(1d, sistema.calcularIngresosPropietario(duenio1, periodo1.getFrom(), periodo1.getTo()));
		assertEquals(2d, sistema.calcularIngresosPropietario(duenio1, periodo1.getFrom(), periodo2.getTo()));
	}
	@Test
	void testCalcularIngresosPropietarioDuenio2() {
		assertEquals(2d, sistema.calcularIngresosPropietario(duenio2, periodo1.getFrom(), periodo2.getTo()));
		assertEquals(6d, sistema.calcularIngresosPropietario(duenio2, periodo3.getFrom(), periodo2.getTo()));
	}
	@Test
	void testCalcularIngresosPeriodoLibre() {
		assertEquals(0d, sistema.calcularIngresosPropietario(duenio2, periodo1.getFrom(), periodo1.getTo()));
	}

}
