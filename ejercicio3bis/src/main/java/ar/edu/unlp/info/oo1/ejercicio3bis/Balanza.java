package ar.edu.unlp.info.oo1.ejercicio3bis;
import java.util.List;
import java.util.ArrayList;

public class Balanza {
	private double precioTotal;
	private double pesoTotal;
	private List<Producto> productos;
	
	public Balanza() {
		this.productos = new ArrayList<>();
		this.precioTotal = 0;
		this.pesoTotal = 0;
	}
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	public double getPrecioTotal() {
		return this.precioTotal;
	}

	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public void ponerEnCero() {
		this.precioTotal = 0;
		this.pesoTotal = 0;
		this.productos.clear();
	}
	
	public void agregarProducto(Producto producto) {
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso();
		this.productos.add(producto);
	}
	public List<Producto> getProductos() {
		return this.productos;
	}
	public Ticket emitirTicket () {
		return new Ticket(this.getProductos(),this.getPesoTotal(),this.getPrecioTotal());
	}
	
}