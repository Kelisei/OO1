package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public interface Politica {
	public double calcularReembolso(LocalDate fechaCancelacion, LocalDate fechaInicio, double monto);
}
