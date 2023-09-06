package ar.edu.unlp.info.oo1.ejercicio3;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	public Item(String detalle, int cantidad, double costoUnitario) {
		this.setDetalle(detalle);
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
	}
	public Item() {}
	public double getCostoUnitario() {
		return costoUnitario;
	}
	public double costo() {
		return cantidad * costoUnitario;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
}
