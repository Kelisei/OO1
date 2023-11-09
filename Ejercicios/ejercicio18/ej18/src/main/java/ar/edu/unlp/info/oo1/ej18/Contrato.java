package ar.edu.unlp.info.oo1.ej18;

import java.time.LocalDate;

public abstract class Contrato {
	private LocalDate fechaInicio;
	private Empleado empleado;

	public Contrato(LocalDate fechaInicio, Empleado empleado) {
		this.fechaInicio = fechaInicio;
		this.empleado = empleado;
	}

	public LocalDate getFechaInicio() {
		return this.getFechaInicio();
	}
	public Empleado getEmpleado() {
		return this.empleado;
	}
	public abstract boolean isVencido();

	public abstract double calcularMonto();

	public abstract int aniosCumplidos();
}
