package ar.edu.unlp.info.oo1.ejercicio7;

public class Empleado {
	private String nombre;
	
	public double montoBasico() {
		return 3500;
	}
	
	public double aportes() {
		return 13500;
	}
	
	public double sueldoBasico() {
		return (this.montoBasico() + this.aportes());
	}
}
