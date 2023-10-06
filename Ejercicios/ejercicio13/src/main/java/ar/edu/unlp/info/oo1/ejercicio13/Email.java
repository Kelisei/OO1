package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private List<Archivo> adjuntos;
	private String titulo;
	private String cuerpo;
	
	public Email(String titulo, String cuerpo) {
		super();
		this.adjuntos = new ArrayList<>();
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public List<Archivo> getAdjuntos(){
		return adjuntos;
	}
	public boolean contiene(String texto) {
		return titulo.contains(texto) || cuerpo.contains(texto);
	}
	public Integer getTamanio() {
		return this.getAdjuntos().stream().mapToInt(Archivo::tamanio).sum() + this.getCuerpo().length() + this.getTitulo().length();
	}
	public void agregarAdjuntos(Archivo a) {
		this.adjuntos.add(a);
	}
}
