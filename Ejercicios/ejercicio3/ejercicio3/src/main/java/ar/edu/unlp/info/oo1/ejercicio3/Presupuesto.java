package ar.edu.unlp.info.oo1.ejercicio3;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> productos;
	
	public Presupuesto(String cliente) {
		this.cliente = cliente;
		fecha = LocalDate.now();
		this.productos = new ArrayList<>();
	}
	public void agregarItem(Item item) {
		productos.add(item);
	}
	public double calcularTotal() {
		double total = 0;
		for (Item item : productos) {
			total += item.costo();
		}
		return total;
	}
	public String getCliente() {
		return cliente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
}
