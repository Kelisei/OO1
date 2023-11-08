package ar.edu.unlp.info.oo1.a;

import java.time.LocalDate;

public class Factura {
	private LocalDate fechaFacturacion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double monto;
	private Cliente cliente;
	public Factura(LocalDate fechaFacturacion, LocalDate fechaInicio, LocalDate fechaFin, double monto, Cliente cliente) {
		this.fechaFacturacion = fechaFacturacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.monto = monto;
		this.cliente = cliente;
	}
	public double getMonto() {
		return this.monto;
	}
}
