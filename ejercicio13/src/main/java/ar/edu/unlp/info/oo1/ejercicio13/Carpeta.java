package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		super();
		this.nombre = nombre;
		this.emails = new ArrayList<>();
	}
	public List<Email> getEmails(){
		return emails;
	}
	public String getNombre() {
		return nombre;
	}
	public void agregar(Email recibido) {
		emails.add(recibido);
	}
	public void eliminar(Email eliminado) {
		emails.remove(eliminado);
	}
	public Email buscar(String texto) {
		return emails.stream().filter(e -> e.contiene(texto)).findFirst().orElse(null);
	}
	public Integer getTamanio() {
		return this.emails.stream().mapToInt(Email::getTamanio).sum();
	}
}
