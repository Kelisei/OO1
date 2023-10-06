package p.ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {

	private List<Pieza> piezas;

	public ReporteDeConstruccion() {
		piezas = new ArrayList<Pieza>();
	}

	public double volumenDeMaterial(String material) {
		return piezas.stream().filter(p -> p.getMaterial().equals(material)).mapToDouble(p -> p.getVolumen()).sum();
	};

	public double superficieDeColor(String color) {
		return piezas.stream().filter(p -> p.getColor().equals(color)).mapToDouble(p -> p.getSuperficie()).sum();
	};
	
	public void addPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
}
