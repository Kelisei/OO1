package p.ej11;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit; 
public class PlazoFijo implements Inversion {
	public LocalDate getFechaDeConstitucion() {
		return fechaDeConstitucion;
	}

	public void setFechaDeConstitucion(LocalDate fechaDeConstitucion) {
		this.fechaDeConstitucion = fechaDeConstitucion;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public void setMontoDepositado(double montoDepositado) {
		this.montoDepositado = montoDepositado;
	}

	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}

	public void setPorcentajeDeInteresDiario(double porcentajeDeInteresDiario) {
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}

	public PlazoFijo(double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = LocalDate.now();
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}

	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;

	@Override
	public double valorActual() {
		int dias = (int) ChronoUnit.DAYS.between(fechaDeConstitucion,  LocalDate.now());
		return this.montoDepositado + (this.montoDepositado * this.porcentajeDeInteresDiario * dias);
	}

}
