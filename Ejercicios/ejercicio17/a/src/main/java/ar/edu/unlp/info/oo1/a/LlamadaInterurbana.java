package ar.edu.unlp.info.oo1.a;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInterurbana extends Llamada {
	private double distancia;

	public LlamadaInterurbana(LocalDate fechaInicio, LocalTime hora, double duracion, String numeroReceptor,
			double distancia) {
		super(fechaInicio, hora, duracion, numeroReceptor);
		this.distancia = distancia;
	}

	@Override
	public double getCosto() {
		double costo;
		if (this.distancia < 100) {
			costo = (this.getDuracion() * 2.0);
		} else if (this.distancia < 500) {
			costo = (this.getDuracion() * 2.5);
		} else {
			costo = (this.getDuracion() * 3.0);
		}
		return (costo + 5.0);
	}

}
