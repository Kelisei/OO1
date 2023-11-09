package ar.edu.unlp.info.oo1.ej18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PorHoras extends Contrato {
	private LocalDate fechaFin;
	private double valorHora;
	private int horas;
	
	public PorHoras(LocalDate fechaInicio, Empleado empleado, LocalDate fechaFin, double valorHora, int horas) {
		super(fechaInicio, empleado);
		this.fechaFin = fechaFin;
		this.valorHora = valorHora;
		this.horas = horas;
	}

	@Override
	public boolean isVencido() {
		return LocalDate.now().isAfter(fechaFin);
	}

	@Override
	public double calcularMonto() {
		return valorHora * horas;
	}

	@Override
	public int aniosCumplidos() {
		if (this.isVencido()) {
			return (int) this.getFechaInicio().until(fechaFin, ChronoUnit.YEARS);
		}
		return (int) this.getFechaInicio().until(LocalDate.now(), ChronoUnit.YEARS);
	}

}
