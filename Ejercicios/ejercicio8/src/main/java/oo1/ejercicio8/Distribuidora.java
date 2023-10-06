package oo1.ejercicio8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;

	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
		usuarios = new ArrayList<Usuario>();
	}

	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public List<Factura> facturar() {
		return this.usuarios.stream().map(u -> u.facturarEnBaseA(this.precioKWh())).collect(Collectors.toList());
	}

	public double consumoTotalActiva() {
		return this.usuarios.stream().mapToDouble(u -> u.ultimoConsumoActiva()).sum();
	}

	public double precioKWh() {
		return this.precioKWh;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public double getPrecioKW() {
		return precioKWh;
	}

	public void setPrecioKW(double precioKWh) {
		this.precioKWh = precioKWh;
	}

}
