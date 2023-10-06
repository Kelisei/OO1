package ar.edu.unlp.info.oo1.ejercicio5;

import java.time.LocalDate;

public class Mamifero {
	private	String identificador;
	private	String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
	}
	public Mamifero() {}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getAbueloMaterno() {
		Mamifero abuelo = null;
		if (this.getMadre() != null) {
			abuelo = this.getMadre().getPadre();
		}
		return abuelo;
	}
	public Mamifero getAbuelaMaterna() {
		Mamifero abuela = null;
		if (this.getMadre() != null) {
			abuela = this.getMadre().getMadre();
		}
		return abuela;
	}
	public Mamifero getAbueloPaterno() {
		Mamifero abuelo = null;
		if (this.getPadre() != null) {
			abuelo = this.getPadre().getPadre();
		}
		return abuelo;
	}
	public Mamifero getAbuelaPaterna() {
		Mamifero abuela = null;
		if (this.getPadre() != null) {
			abuela = this.getPadre().getMadre();
		}
		return abuela;
	}
	public boolean tieneComoAncestroA(Mamifero unMamimefero) {
		boolean esta = false;
		Mamifero papa = this.getPadre();
		if (papa != null) {
			esta = (unMamimefero == padre);
			if (!esta) {
				esta = papa.tieneComoAncestroA(unMamimefero);
			}
		} 
		if (!esta) {
			Mamifero mama = this.getMadre();
			if (mama != null) {
				esta = (unMamimefero == mama);
				if (!esta) {
					esta = mama.tieneComoAncestroA(unMamimefero);
				}
			}
		}
		return esta;
	}
	
}
