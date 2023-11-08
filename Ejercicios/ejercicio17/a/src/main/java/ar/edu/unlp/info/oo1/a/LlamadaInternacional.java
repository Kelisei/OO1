package ar.edu.unlp.info.oo1.a;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada{
	private String paisOrigen;
	private String paisDestino;
	public LlamadaInternacional(LocalDate fechaInicio, LocalTime hora, double duracion, String numeroReceptor, String paisOrigen, String paisDestino) {
		super(fechaInicio, hora, duracion, numeroReceptor);
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
	}
	@Override 
	public double getCosto() {
		if (this.getHora().isAfter(LocalTime.of(8, 0)) && this.getHora().isBefore(LocalTime.of(20, 0))) {
			return this.getDuracion() * 4;
		} 
		return this.getDuracion() * 3;
	}
}
