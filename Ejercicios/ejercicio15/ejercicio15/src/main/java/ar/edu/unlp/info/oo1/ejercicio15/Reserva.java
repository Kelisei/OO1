package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public class Reserva {
	private DateLapse periodo;
	private Usuario inquilino;
	private Propiedad propiedad;
	
	public Reserva (LocalDate desde, LocalDate hasta, Propiedad propiedad, Usuario inquilino) {
		this.periodo = new DateLapse(hasta, desde);
		this.propiedad = propiedad;
		this.inquilino = inquilino;
	}
	
	public double precioTotal() {
		return this.getPropiedad().getPrecioPorNoche() * this.periodo.sizeInDays();
	}
	
	public boolean yaPaso() {
		return LocalDate.now().isBefore(this.periodo.getTo());
	}
	public int duracion() {
		return this.periodo.sizeInDays();
	}
	// ----Getters y setters----
	public DateLapse getPeriodo() {
		return periodo;
	}

	public void setPeriodo(DateLapse periodo) {
		this.periodo = periodo;
	}

	public Usuario getInquilino() {
		return inquilino;
	}

	public void setInquilino(Usuario inquilino) {
		this.inquilino = inquilino;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	public boolean solapado(DateLapse periodo) {
		return this.getPeriodo().overlaps(periodo);
	}
	
}
