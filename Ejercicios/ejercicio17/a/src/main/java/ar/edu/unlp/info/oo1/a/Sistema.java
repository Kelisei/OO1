package ar.edu.unlp.info.oo1.a;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<String> numeros;
	private List<Cliente> clientes;

	public Sistema() {
		numeros = new ArrayList<>();
		clientes = new ArrayList<>();
	}

	public void agregarNumero(String numero) {
		this.numeros.add(numero);
	}

	private void eliminarNumero(String numero) {
		this.numeros.remove(numero);
	}

	private String getNumero() {
		return this.numeros.get(0);
	}
	
	private void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	private String conseguirNumeroDisponbile() {
		String numero = this.getNumero();
		this.eliminarNumero(numero);
		return numero;
	}

	public Cliente altaPersonaFisica(String nombre, String direccion, String dni) {
		String numero = conseguirNumeroDisponbile();
		Cliente cliente = new PersonaFisica(nombre, direccion, numero, dni);
		agregarCliente(cliente);
		return cliente;
	}

	public Cliente altaPersonaJuridica(String nombre, String direccion, String CUIT, String tipo) {
		String numero = conseguirNumeroDisponbile();
		Cliente cliente = new PersonaJuridica(nombre, direccion, numero, CUIT, tipo);
		agregarCliente(cliente);
		return cliente;
	}

	public Cliente getClienteDeNumero(String numero) {
		return this.clientes.stream().filter(c -> c.getNumero().equals(numero)).findFirst().orElse(null);
	}
	
	public Llamada registrarLlamadaLocal(LocalDate fecha, LocalTime hora, double duracion, String numeroReceptor, String numeroEmisor) {
		Cliente cliente = getClienteDeNumero(numeroEmisor);
		return cliente.registrarLlamadaLocal(fecha, hora, duracion, numeroReceptor);
	}
	
	public Llamada registrarLlamadaInterurbana(LocalDate fecha, LocalTime hora, double duracion, String numeroReceptor, Double distancia, String numeroEmisor) {
		Cliente cliente = getClienteDeNumero(numeroEmisor);
		return cliente.registrarLlamadaInterurbana(fecha, hora, duracion, numeroReceptor, distancia);
	}
	
	public Llamada registrarLlamadaInternacional(LocalDate fecha, LocalTime hora, double duracion, String numeroReceptor, String paisOrigen, String paisDestino, String numeroEmisor) {
		Cliente cliente = getClienteDeNumero(numeroEmisor);
		return cliente.registrarLlamadaInternacional(fecha, hora, duracion, numeroReceptor, paisOrigen, paisDestino);
	}
	public Factura facturar(Cliente cliente, LocalDate fechaInicio, LocalDate feachFin) {
		return cliente.facturar(fechaInicio, fechaInicio, LocalDate.now());
	}
}
