package ar.edu.unlp.info.oo1.a;

import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada {
	private LocalDate fechaInicio; 
	private LocalTime hora;
	private double duracion;
	private String numeroReceptor;
	
	public Llamada(LocalDate fechaInicio, LocalTime hora, double duracion, String numeroReceptor) {
		this.fechaInicio = fechaInicio;
		this.hora = hora;
		this.duracion = duracion;
		this.numeroReceptor = numeroReceptor;
	}
	public double getCosto() {
		return this.duracion;
	}
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	public double getDuracion() {
		return this.duracion;
	}
	public LocalTime getHora() {
		return this.hora;
	}
}
