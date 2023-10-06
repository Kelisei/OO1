package oo1.ejercicio8;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;

	public Factura(double montoEnergiaActivo, double descuento, Usuario usuario) {
		super();
		this.montoEnergiaActiva = montoEnergiaActivo;
		this.descuento = descuento;
		this.fecha = LocalDate.now();
		this.usuario = usuario;
	}

	public double montoTotal() {
		return this.montoEnergiaActiva - (this.montoEnergiaActiva * (this.getDescuento() / 100));
	}

	public double getMontoEnergiaActiva() {
		return montoEnergiaActiva;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getDescuento() {
		return descuento;
	}
}
