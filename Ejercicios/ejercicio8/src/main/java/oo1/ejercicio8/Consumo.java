package oo1.ejercicio8;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;

	public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
		super();
		this.fecha = fecha;
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}

	public double constoEnBase(double precioKWh) {
		return this.getConsumoEnergiaActiva() * precioKWh;
	}

	public double factorDePotencial() {
		return this.getConsumoEnergiaActiva()
				/ (Math.sqrt((Math.pow(this.getConsumoEnergiaActiva(), 2) + Math.pow(getConsumoEnergiaReactiva(), 2))));
	}

	public double getConsumoEnergiaActiva() {
		return consumoEnergiaActiva;
	}

	public void setConsumoEnergiaActiva(double consumoEnergiaActiva) {
		this.consumoEnergiaActiva = consumoEnergiaActiva;
	}

	public double getConsumoEnergiaReactiva() {
		return consumoEnergiaReactiva;
	}

	public void setConsumoEnergiaReactiva(double consumoEnergiaReactiva) {
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
