package p.ej11;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	private String nombre;
	private List <Inversion> inversiones;
	
	public Inversor(String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList <Inversion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSizeInversiones() {
		return inversiones.size();
	}

	public void agregarInversion (Inversion inversion) {
		this.inversiones.add(inversion);
	}
	
	public double valorActual() {
		return this.inversiones.stream().mapToDouble(inversion -> inversion.valorActual()).sum();
	}
	
	
	
}
