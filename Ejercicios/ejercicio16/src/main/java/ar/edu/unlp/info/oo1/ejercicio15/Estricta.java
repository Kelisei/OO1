package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public class Estricta implements Politica {

	@Override
	public double calcularReembolso(LocalDate fechaCancelacion, LocalDate fechaInicio, double monto) {
		return 0;
	}
}
