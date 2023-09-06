package ar.edu.unlp.info.oo1.ejercicio4;

public class Cuadrado implements Cuerpo2D{
	private double lado;
	@Override
	public double getPerimetro() {
		return lado * 4;
	}

	@Override
	public double getArea() {
		return lado * lado;
	}
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getLado() {
		return lado;
	}
}
