package ar.edu.unlp.info.oo1.ej18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlantaPermanente extends Contrato {
	private double mensualidad;
	private double porConyugeACargo;
	private double porHijoACargo;
	public PlantaPermanente(LocalDate fechaInicio, Empleado empleado, double mensualidad, double porConyugeACargo, double porHijoACargo) {
		super(fechaInicio, empleado);
		this.mensualidad = mensualidad;
		this.porConyugeACargo = porConyugeACargo;
		this.porHijoACargo = porHijoACargo;
	}

	@Override
	public boolean isVencido() {
		return false;
	}

	@Override
	public double calcularMonto() {
		double montoFinal = mensualidad;
		if (this.getEmpleado().isACargoDeConyuge()) {
			montoFinal += this.porConyugeACargo;
		}
		if (this.getEmpleado().isACargoDeHijos()) {
			montoFinal += this.porHijoACargo;
		}
		return montoFinal;
	}

	@Override
	public int aniosCumplidos() {
		return (int) this.getFechaInicio().until(LocalDate.now(), ChronoUnit.YEARS);
	}

}
