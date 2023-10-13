package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OOBnB {
	private List<Usuario> usuarios;

	public OOBnB() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public Usuario aniadirUsuario(String nombre, String descripccion, String dni) {
		Usuario nuevoUsuario = new Usuario(nombre, descripccion, dni);
		usuarios.add(nuevoUsuario);
		return nuevoUsuario;
	}

	public Propiedad aniadirPropiedad(String nombre, String descripccion, double PrecioPorNoche, Usuario duenio) {
		Propiedad nuevaPropiedad = new Propiedad(duenio, descripccion, PrecioPorNoche, descripccion);
		duenio.aniadirPropiedad(nuevaPropiedad);
		return nuevaPropiedad;
	}

	public List<Propiedad> getPropiedadesDisponibles(LocalDate desde, LocalDate hasta) {
		return this.usuarios.stream().flatMap(u -> u.propiedadesDisponible(desde, hasta).stream())
				.collect(Collectors.toList());
	}

	public Reserva aniadirReserva(LocalDate desde, LocalDate hasta, Usuario inquilino, Propiedad propiedad) {
		Reserva nuevaReserva = new Reserva(desde, hasta, propiedad, inquilino);
		if (propiedad.estaLibre(nuevaReserva)) {
			inquilino.aniadirReserva(nuevaReserva);
			propiedad.aniadirReserva(nuevaReserva);
			return nuevaReserva;
		}
		return null;
	}

	public double precioDeUnaReserva(Reserva reserva) {
		return reserva.precioTotal();
	}

	public void eliminarReserva(Reserva reserva) {
		if (reserva.yaPaso()) {
			reserva.getInquilino().eliminarReserva(reserva);
			reserva.getPropiedad().eliminarReserva(reserva);
		}
	}

	public List<Reserva> getReservas(Usuario inquilino) {
		return inquilino.getReservas();
	}

	public double calcularIngresosPropietario(Usuario propietario, LocalDate desde, LocalDate hasta) {
		return propietario.calcularIngresos(desde, hasta);
	}

}
