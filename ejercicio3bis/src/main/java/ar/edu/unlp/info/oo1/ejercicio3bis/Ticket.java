package ar.edu.unlp.info.oo1.ejercicio3bis;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Ticket {
	private java.time.LocalDate fecha;
	private List<Producto> productos;
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket() {
		
	}
	
	public Ticket(List<Producto> productos, double pesoTotal, double precioTotal) {
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
		this.fecha = LocalDate.now();
		this.productos = new ArrayList<>(productos);
	}
	
	public java.time.LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(java.time.LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public int getCantidadDeProductos() {
		return productos.size();
	}
	
	public List<Producto> getProductos() {
		return this.productos;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public double impuesto() {
		return (this.getPrecioTotal() * 0.21);
	}
	

}