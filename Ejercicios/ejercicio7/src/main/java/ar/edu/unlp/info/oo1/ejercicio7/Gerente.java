package ar.edu.unlp.info.oo1.ejercicio7;

public class Gerente extends EmpleadoJerarquico{
	@Override
	public double aportes() {
		return this.montoBasico() * 0.05d;
	}
	
	@Override
	public double montoBasico() {
		return 57000;
	}
}
