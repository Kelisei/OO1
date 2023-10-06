package ar.edu.unlp.info.oo1.ejercicio6;

import java.util.List;
import	java.util.ArrayList; 

public class Farola {
	boolean on;
	List<Farola> neighbors;
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	public Farola () {
		on = false;
		neighbors = new ArrayList<>();
	}
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos
	entre las farolas es recíproca, es decir el receptor del mensaje será vecino
	de otraFarola, al igual que otraFarola también se convertirá en vecina del
	receptor del mensaje
	*/
	public void pairWithNeighbor( Farola otraFarola ) {
		this.addNeighbors(otraFarola);
		otraFarola.addNeighbors(this);
	}
	public void addNeighbors(Farola otraFarola) {
		this.neighbors.add(otraFarola);
	}
	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors (){
		return this.neighbors;
	}
	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (!this.on) {
			this.on = true;
			this.neighbors.stream().forEach(Farola::turnOn);
		}
	}
	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (this.on) {
			this.on = false;
			this.neighbors.stream().forEach(Farola::turnOff);
		}
	}
	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		return on;
	}
}
