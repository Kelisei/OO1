package p.ejercicio12;

public class Cilindro extends Pieza {

	private double radio;
	private double altura;

	public Cilindro(String material, String color, double radio, double altura) {
		super(material, color);
		this.radio=radio;
		this.altura=altura;
	}
	@Override
	public double getVolumen() {
		return Math.PI * (radio * radio) * altura;
	}

	@Override
	public double getSuperficie() {
		return 2 * Math.PI * radio * altura + 2 * Math.PI * Math.pow(radio, 2);
	}

}
