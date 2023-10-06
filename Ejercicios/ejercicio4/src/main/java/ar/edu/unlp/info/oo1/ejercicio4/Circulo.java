package ar.edu.unlp.info.oo1.ejercicio4;
public class Circulo implements Cuerpo2D{
	private double diametro;
	
	@Override
	public double getPerimetro() {
		return 2 * Math.PI * this.getRadio();
	}

	@Override
	public double getArea() {
		return Math.PI * (Math.pow(this.getRadio(), 2));
	}
	public double getDiametro() {
		return diametro;
	}
	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	public double getRadio() {
		return diametro / 2;
	}
	public void setRadio(double radio) {
		diametro = radio * 2;
	}
}
