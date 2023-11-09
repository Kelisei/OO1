package ar.edu.unlp.info.oo1.ej18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
	private Empleado empleadoConContratoVencido;
	private Empleado empleadoSinContratoVencido;
	private Empleado empleado4Años;
	private Empleado empleado5Años;
	private Empleado empleado10Años;
	private Empleado empleado15Años;
	private Empleado empleado20Años;
	
	@BeforeEach
	public void setUp() {
		this.empleadoConContratoVencido = new Empleado("Jose","Diaz","123",LocalDate.of(2002, 10, 24),false, true, LocalDate.of(2004, 1, 1));
		this.empleadoSinContratoVencido = new Empleado("Maria","Diaz","123",LocalDate.of(2002, 10, 24),false, true, LocalDate.of(2004, 1, 1));
		
		this.empleado4Años = new Empleado("Juan","Diaz","123",LocalDate.of(2002, 10, 24),false, true, LocalDate.of(2004, 1, 1));
		this.empleado5Años = new Empleado("Pedro","Diaz","123",LocalDate.of(2002, 10, 24),false, true, LocalDate.of(2004, 1, 1));
		this.empleado10Años = new Empleado("Tamara","Diaz","123",LocalDate.of(2002, 10, 24),false, true, LocalDate.of(2004, 1, 1));
		this.empleado15Años = new Empleado("Veronica","Diaz","123",LocalDate.of(2002, 10, 24),false, true, LocalDate.of(2004, 1, 1));
		this.empleado20Años = new Empleado("Felipe","Diaz","123",LocalDate.of(2002, 10, 24),false, true, LocalDate.of(2004, 1, 1));
		
		this.empleadoConContratoVencido.cargarContratoPorHoras(LocalDate.of(2016, 9, 20), LocalDate.of(2022, 10, 23), 100, 100);
		this.empleadoConContratoVencido.cargarContratoPorHoras(LocalDate.of(2023, 9, 20), LocalDate.of(2022, 10, 23), 100, 100); 
		this.empleadoSinContratoVencido.cargarContratoPermanente(LocalDate.of(2023, 10, 24), 100.0, 100.0, 100.0);
		this.empleadoSinContratoVencido.cargarContratoPorHoras(LocalDate.of(2016, 9, 20), LocalDate.of(2022, 10, 23), 100, 100);
		this.empleadoSinContratoVencido.cargarContratoPorHoras(LocalDate.of(2023, 9, 20), LocalDate.of(2022, 10, 23), 100, 100);
		
		this.empleado4Años.cargarContratoPorHoras(LocalDate.of(2014, 9, 20), LocalDate.of(2017, 10, 23), 100, 100);
		this.empleado4Años.cargarContratoPorHoras(LocalDate.of(2022, 11, 02), LocalDate.of(2024, 11, 02), 100, 100);
		this.empleado5Años.cargarContratoPermanente(LocalDate.of(2018, 10, 24), 100.0, 100.0, 100.0);
		this.empleado10Años.cargarContratoPorHoras(LocalDate.of(2012, 9, 20), LocalDate.of(2022, 10, 23), 100, 100);
		this.empleado10Años.cargarContratoPermanente(LocalDate.of(2023, 10, 24), 100.0, 100.0, 100.0);
		this.empleado15Años.cargarContratoPorHoras(LocalDate.of(2007, 9, 20), LocalDate.of(2012, 10, 23), 100, 100); 
		this.empleado15Años.cargarContratoPermanente(LocalDate.of(2013, 10, 24), 100.0, 100.0, 100.0);
		this.empleado20Años.cargarContratoPorHoras(LocalDate.of(2002, 9, 20), LocalDate.of(2022, 10, 23), 100, 100);
		this.empleado20Años.cargarContratoPorHoras(LocalDate.of(2023, 10, 23), LocalDate.of(2024, 11, 23), 100, 100);
	}
	@Test
	public void getContratoVigenteTest(){
		assertNotNull(empleadoConContratoVencido.getContratoVigente());
	}
	@Test
	public void tieneContratoVencidoTest() {
		assertTrue(empleadoConContratoVencido.isContratoVigenteVencido());
		assertFalse(empleadoSinContratoVencido.isContratoVigenteVencido());
	}
	@Test void getAntiguedadTest() {
		assertEquals(4, this.empleado4Años.getAntiguedad());
		assertEquals(5, this.empleado5Años.getAntiguedad());
		assertEquals(10, this.empleado10Años.getAntiguedad());
		assertEquals(15, this.empleado15Años.getAntiguedad());
		assertEquals(20, this.empleado20Años.getAntiguedad());
	}
	@Test void ReciboTest() {
		assertEquals(10000, this.empleado4Años.generarRecibo().getMonto());
		assertEquals(260, this.empleado5Años.generarRecibo().getMonto());
		assertEquals(300, this.empleado10Años.generarRecibo().getMonto());
		assertEquals(340, this.empleado15Años.generarRecibo().getMonto());
		assertEquals(20000, this.empleado20Años.generarRecibo().getMonto());
	}
}
