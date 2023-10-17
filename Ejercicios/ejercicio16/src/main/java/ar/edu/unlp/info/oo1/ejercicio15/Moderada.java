package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Moderada implements Politica {

	@Override
	public double calcularReembolso(LocalDate fechaCancelacion, LocalDate fechaInicio, double monto) {
		if (fechaInicio.isAfter(fechaCancelacion)){
			if (ChronoUnit.DAYS.between(fechaCancelacion, fechaInicio) >= 7) {
				return monto;
			} else if (ChronoUnit.DAYS.between(fechaCancelacion, fechaInicio) >= 2) {
				return monto/2;
			}

		}
		return 0;
	}
}
