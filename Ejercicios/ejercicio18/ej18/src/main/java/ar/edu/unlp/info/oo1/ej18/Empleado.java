package ar.edu.unlp.info.oo1.ej18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre;
	private String apellido;
	private String CUIL;
	private LocalDate fechaNacimiento;
	private boolean aCargoDeConyuge;
	private boolean aCargoDeHijos;
	private LocalDate inicioRelacionLaboral;
	private List<Contrato> contratos;
	private List<Recibo> recibos;
	 
	public Empleado(String nombre, String apellido, String CUIL, LocalDate fechaNacimiento, boolean aCargoDeConyuge,
			boolean aCargoDeHijos, LocalDate inicioRelacionLaboral) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.CUIL = CUIL;
		this.fechaNacimiento = fechaNacimiento;
		this.aCargoDeConyuge = aCargoDeConyuge;
		this.aCargoDeHijos = aCargoDeHijos;
		this.inicioRelacionLaboral = inicioRelacionLaboral;
		this.contratos = new ArrayList<>();
		this.recibos = new ArrayList<>();
	}

	public String getCUIL() {
		return this.CUIL;
	}

	public boolean isACargoDeConyuge() {
		return this.aCargoDeConyuge;
	}

	public boolean isACargoDeHijos() {
		return this.aCargoDeHijos;
	}

	public void cargarContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorHora,
			int horas) {
		if (this.isContratoVigenteVencido()) {
			PorHoras contrato = new PorHoras(fechaInicio, this, fechaFin, valorHora, horas);
			contratos.add(contrato);
		}
	}
	public void cargarContratoPermanente(LocalDate fechaInicio, double mensualidad,
			double porConyuge, double porHijos) {
		if (this.isContratoVigenteVencido()) {
			PlantaPermanente contrato = new PlantaPermanente(fechaInicio, this, mensualidad, porConyuge, porHijos);
			contratos.add(contrato);
		}
	}

	public List<Contrato> getContratos() {
		return this.contratos;
	}

	public Contrato getContratoVigente() {
		return this.getContratos().stream()
				.max((Contrato c1, Contrato c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio())).orElse(null);
	}

	public boolean isContratoVigenteVencido() {
		Contrato vigente = this.getContratoVigente();
		if (vigente != null) {
			return this.getContratoVigente().isVencido();
		}
		return true;
	}

	public int getAntiguedad() {
		return this.contratos.stream().mapToInt(c -> c.aniosCumplidos()).sum();
	}

	private double getAumento() {
		double aumento = 1.0;
		if (this.getAntiguedad() >= 5 && this.getAntiguedad() < 10) {
			aumento += 0.3;
		} else if (this.getAntiguedad() >= 10 && this.getAntiguedad() < 15) {
			aumento += 0.5;
		} else if (this.getAntiguedad() >= 15 && this.getAntiguedad() < 20) {
			aumento += 0.7;
		} else if (this.getAntiguedad() >= 20) {
			aumento += 1;
		}
		return aumento;
	}

	public double getPagoTotal() {
		if (!this.isContratoVigenteVencido()) {
			return this.getContratoVigente().calcularMonto() * this.getAumento();
		}
		return 0;
	}

	public Recibo generarRecibo() {
		Recibo r = new Recibo(this.nombre, this.apellido, this.CUIL, this.getAntiguedad(), this.getPagoTotal());
		this.recibos.add(r);
		return r;
	}
}
