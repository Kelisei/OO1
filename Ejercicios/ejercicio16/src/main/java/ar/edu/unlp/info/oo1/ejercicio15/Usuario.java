package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Usuario {
	private String nombre;
	private String direccion;
	private String dni;
	private List<Propiedad> propiedades;
	private List<Reserva> historialReservas;
	
	public Usuario(String nombre, String dni, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedades = new ArrayList<Propiedad>();
		this.historialReservas = new ArrayList<Reserva>();
	}
	public List<Reserva> getReservas(){
		return this.historialReservas;
	}
	public void eliminarReserva(Reserva reserva) {
		this.historialReservas.remove(reserva);
	}
	public void aniadirReserva(Reserva reserva) {
		this.historialReservas.add(reserva);
	}
	public void aniadirPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	public void eliminarPropiedad(Propiedad propiedad) {
		this.propiedades.remove(propiedad);
	}
	public double calcularIngresos(LocalDate desde, LocalDate hasta) {
		DateLapse periodo = new DateLapse(hasta, desde);
		return this.getPropiedades().stream().mapToDouble(p -> p.getPrecioReservasEnUnPeriodo(periodo)).sum();
	}
	public List<Propiedad> propiedadesDisponible(LocalDate desde, LocalDate hasta) {
		DateLapse periodo = new DateLapse(hasta, desde);
		return this.propiedades.stream().filter(p -> p.estaLibre(periodo)).toList();
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public List<Propiedad> getPropiedades() {
		return propiedades;
	}
	
}
