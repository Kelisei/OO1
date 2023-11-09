package ar.edu.unlp.info.oo1.ej18;

import java.time.LocalDate;

public class Recibo {
	private String nombre;
	private String apellido;
	private String CUIL;
	int antiguedad;
	private LocalDate fechaDeCreacion;
	private double montoTotal;

	public Recibo(String nombre, String apellido, String CUIL, int antiguedad, double montoSueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.CUIL = CUIL;
		this.antiguedad = antiguedad;
		this.fechaDeCreacion = LocalDate.now();
	}
}
