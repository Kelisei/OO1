package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		super();
		this.inbox = new Carpeta("Inbox");
		this.carpetas = new ArrayList<>();
		this.carpetas.add(inbox);
	}
	public void recibir(Email email) {
		inbox.agregar(email);
	}
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		origen.eliminar(email);
		destino.agregar(email);
	}
	public Email buscar(String texto) {
		return carpetas.stream().map(c -> c.buscar(texto)).filter(e -> e != null).findFirst().orElse(null);
	}
	public Integer espacioOcupado() {
		return this.carpetas.stream().mapToInt(Carpeta::getTamanio).sum();
		
	}
	public void agregarCarpeta(Carpeta c) {
		this.carpetas.add(c);
	}
	public Carpeta getCarpeta(String nombre) {
		return this.carpetas.stream().filter(c -> Objects.equals(c.getNombre(), nombre)).findFirst().orElse(null);
	}
}
