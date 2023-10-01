package p.ejercicio12;

public class Esfera extends Pieza {

	private double radio;
	public Esfera(String material, String color, double radio) {
		super(material, color);
		this.radio=radio;
	}
	@Override
	public double getVolumen() {
		return Math.pow(radio, 3) * Math.PI * (4d/3d);
	}

	@Override
	public double getSuperficie() {
		return 4 * Math.PI * Math.pow(radio, 2);
	}

}
