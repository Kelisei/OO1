package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public class Flexible implements Politica {

	@Override
	public double calcularReembolso(LocalDate fechaCancelacion, LocalDate fechaInicio, double monto) {
		if (fechaInicio.isAfter(fechaCancelacion)) {
			return monto;
		}
		return 0;
	}
}
