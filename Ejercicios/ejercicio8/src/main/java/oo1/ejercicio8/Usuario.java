package oo1.ejercicio8;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Consumo> consumos;
	private List<Factura> facturas;

	public Usuario(String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.consumos = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}

	public double ultimoConsumoActiva() {
		Consumo ultimo = ultimoConsumo();
		if (ultimo == null) {
			return 0.0;
		}
		return ultimo.getConsumoEnergiaActiva();
	}

	public Consumo ultimoConsumo() {
		return this.consumos.stream().max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha()))
				.orElse(null);
	}

	public Factura facturarEnBaseA(double precioKWh) {
		Factura nuevaFactura = null;
		Consumo ultimoConsumo = this.ultimoConsumo();
		if (ultimoConsumo == null) {
			nuevaFactura = new Factura(0, 0, this);
		} else {
			if (ultimoConsumo.factorDePotencial() > 0.8) {
				nuevaFactura = new Factura(ultimoConsumo.constoEnBase(precioKWh), 10, this);
			} else {
				nuevaFactura = new Factura(ultimoConsumo.constoEnBase(precioKWh), 0, this);
			}
		}
		return nuevaFactura;
	}

	public List<Factura> facturas() {
		return this.facturas;
	}
}
