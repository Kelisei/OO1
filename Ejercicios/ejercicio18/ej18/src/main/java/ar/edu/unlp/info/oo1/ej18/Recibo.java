package ar.edu.unlp.info.oo1.ej18;

import java.time.LocalDate;

public class Recibo {
	private String nombre;
	private String apellido;
	private String CUIL;
	private int antiguedad;
	private LocalDate fechaDeCreacion;
	private double montoTotal;

	public Recibo(String nombre, String apellido, String CUIL, int antiguedad, double montoTotal) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.CUIL = CUIL;
		this.antiguedad = antiguedad;
		this.fechaDeCreacion = LocalDate.now();
		this.montoTotal = montoTotal;
	}
	public double getMonto() {
		return montoTotal;
	}
}
