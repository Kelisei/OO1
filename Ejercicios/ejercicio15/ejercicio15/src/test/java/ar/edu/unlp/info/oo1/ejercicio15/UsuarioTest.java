package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	private Reserva reserva;
	private Propiedad propiedad;
	private Usuario inquilino;
	private Usuario duenio;
	private DateLapse periodo1;
	@BeforeEach
	void setUp() {
		inquilino = new Usuario("Jose Jacinto Rivera", "45.222.222", "373 e/ 2 y 24");
		duenio = new Usuario("Kakaroto", "22.000.000", "377 e/ 2 y 24");
		
		propiedad = new Propiedad(duenio, "La Casona", 4000d, "371 e/ 2 y 24");
		duenio.aniadirPropiedad(propiedad);
		periodo1 = new DateLapse(LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 10));
		reserva = new Reserva(periodo1.getFrom(), periodo1.getTo(), propiedad, inquilino);
		duenio.aniadirReserva(reserva);
		propiedad.aniadirReserva(reserva);
		
	}
	@Test
	void testCalcularIngresosUsuarioConPropiedades() {
		assertEquals(4000d , duenio.calcularIngresos(periodo1.getFrom(), periodo1.getTo()));
	}
	@Test
	void testCalcularIngresosPeriodoSinReservas() {
		assertEquals(0d , duenio.calcularIngresos(periodo1.getFrom().plusDays(20), periodo1.getTo().plusDays(20)));
	}
	@Test
	void testCalcularIngresosUsuarioSinPropiedades() {
		assertEquals(0d , inquilino.calcularIngresos(periodo1.getFrom(), periodo1.getTo()));
	}
	@Test
	void testPropiedadesDisponiblePeriodoConReservas() {
		assertEquals(0 ,duenio.propiedadesDisponible(periodo1.getFrom(), periodo1.getTo()).size());
	}
	@Test
	void testPropiedadesDisponiblePeriodoSinReservas() {
		assertEquals(1 ,duenio.propiedadesDisponible(periodo1.getFrom().plusDays(20), periodo1.getTo().plusDays(20)).size());
	}
}
