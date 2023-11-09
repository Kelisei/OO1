package ar.edu.unlp.info.oo1.ej18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Empleado> nomina;

	public Sistema() {
		nomina = new ArrayList<>();
	}

	private void agregarALaNomina(Empleado empleado) {
		this.nomina.add(empleado);
	}

	public Empleado darDeAltaEmpleado(String nombre, String apellido, String CUIL, LocalDate fechaNacimiento,
			boolean aCargoDeConyuge, boolean aCargoDeHijos, LocalDate inicioDeRelacionLaboral) {
		Empleado empleado = new Empleado(nombre, apellido, CUIL, fechaNacimiento, aCargoDeConyuge, aCargoDeHijos,
				inicioDeRelacionLaboral);
		this.agregarALaNomina(empleado);
		return empleado;
	}

	public Empleado buscarEmpleado(String CUIL) {
		return this.nomina.stream().filter(e -> e.getCUIL() == CUIL).findFirst().orElse(null);
	}

	public void reventarEmpleado(Empleado e) {
		this.nomina.remove(e);
	}

	public void cargarContratoPorHoras(Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, double valorHora,
			int horas) {
		empleado.cargarContratoPorHoras(fechaInicio, fechaFin, valorHora, horas);
	}

	public void cargarContratoPermanente(Empleado empleado, LocalDate fechaInicio, double mensualidad,
			double porConyuge, double porHijos) {
		empleado.cargarContratoPermanente(fechaInicio, mensualidad, porConyuge, porHijos);
	}

	public List<Empleado> empleadosConContratosVencidos() {
		return this.nomina.stream().filter(e -> e.isContratoVigenteVencido()).toList();
	}

	public List<Recibo> generarRecibos() {
		return this.nomina.stream().map(e -> e.generarRecibo()).toList();
	}
}
