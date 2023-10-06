package ar.edu.unlp.info.oo1.ejercicio4;

public class Cuerpo3D {
	private double altura;
	private Cuerpo2D caraBasal;
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public Cuerpo2D getCaraBasal() {
		return caraBasal;
	}
	
	public void setCaraBasal(Cuerpo2D caraBasal) {
		this.caraBasal = caraBasal;
	}
		
	public double getSuperficieExterior() {
		return (2 * this.getCaraBasal().getArea() + this.getCaraBasal().getPerimetro() * this.getAltura());
	}
	
	public double getVolumen() {
		return (this.getCaraBasal().getArea() * this.getAltura());
	}	
	
	

}
