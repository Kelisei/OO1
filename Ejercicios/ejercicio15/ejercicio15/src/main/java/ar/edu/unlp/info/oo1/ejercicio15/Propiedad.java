package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private Usuario duenio;
	private String nombre;
	private double precioPorNoche;
	private String direccion;
	private List<Reserva> reservas;
	public Propiedad(Usuario duenio, String nombre, double precioPorNoche, String direccion) {
		this.duenio = duenio;
		this.nombre = nombre;
		this.precioPorNoche = precioPorNoche;
		this.direccion = direccion;
		this.reservas = new ArrayList<Reserva>();
	}
	public double getPrecioReservasEnUnPeriodo(DateLapse periodo) {
		return this.reservas.stream().filter(r -> r.solapado(periodo)).mapToDouble(r -> r.precioTotal()).sum();
	}
	public void aniadirReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	public void eliminarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	public boolean estaLibre(DateLapse periodo) {
		// Si esta solapado retorna False
		// Si no retorna true
		return this.reservas.stream().noneMatch(reserva -> reserva.solapado(periodo));
	}
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	// ---Getters y setters---
	public Usuario getDuenio() {
		return duenio;
	}
	public void setDuenio(Usuario duenio) {
		this.duenio = duenio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	
}
