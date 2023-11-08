package ar.edu.unlp.info.oo1.a;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	protected String nombre;
	private String direccion;
	private String numero;
	private List<Llamada> llamadas;
	private List<Factura> facturas;

	public Cliente(String nombre, String direccion, String numero) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.numero = numero;
		this.llamadas = new ArrayList<>();
		this.facturas = new ArrayList<>();
	}

	public Llamada registrarLlamadaLocal(LocalDate fecha, LocalTime hora, double duracion, String numeroReceptor) {
		Llamada llamada = new Llamada(fecha, hora, duracion, numeroReceptor);
		this.agregarLlamada(llamada);
		return llamada;
	}

	public Llamada registrarLlamadaInterurbana(LocalDate fecha, LocalTime hora, double duracion, String numeroReceptor,
			double distancia) {
		Llamada llamada = new LlamadaInterurbana(fecha, hora, duracion, numeroReceptor, distancia);
		this.agregarLlamada(llamada);
		return llamada;
	}

	public Llamada registrarLlamadaInternacional(LocalDate fecha, LocalTime hora, double duracion,
			String numeroReceptor, String paisOrigen, String paisDestino) {
		Llamada llamada = new LlamadaInternacional(fecha, hora, duracion, numeroReceptor, paisOrigen, paisDestino);
		this.agregarLlamada(llamada);
		return llamada;
	}
	//Dejar privado dps
	public double montoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		return this.getLlamadas().stream()
				.filter(l -> (l.getFechaInicio().isAfter(fechaInicio) || l.getFechaInicio().isEqual(fechaInicio))
						&& (l.getFechaInicio().isBefore(fechaFin) || l.getFechaInicio().isEqual(fechaFin)))
				.mapToDouble(l -> l.getCosto()).sum();
	}

	protected abstract double aplicarDescuento(double monto);

	public Factura facturar(LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaFacturacion) {
		Factura factura = new Factura(fechaFacturacion, fechaInicio, fechaFin,
				aplicarDescuento(montoEntreFechas(fechaInicio, fechaFin)), this);
		this.agregarFactura(factura);
		return factura;
	}

	private void agregarLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}

	private void agregarFactura(Factura factura) {
		this.facturas.add(factura);
	}

	public List<Llamada> getLlamadas() {
		return this.llamadas;
	}

	public String getNumero() {
		return this.numero;
	}
}
