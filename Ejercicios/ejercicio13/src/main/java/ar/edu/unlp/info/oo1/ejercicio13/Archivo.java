package ar.edu.unlp.info.oo1.ejercicio13;

public class Archivo {
	String nombre;
	
	public Archivo(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public Integer tamanio() {
		return this.getNombre().length();
	}
}
