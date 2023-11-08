package ar.edu.unlp.info.oo1.a;
public class PersonaFisica extends Cliente {
	private String dni;

	public PersonaFisica(String nombre, String direccion, String numero, String dni) {
		super(nombre, direccion, numero);
		this.dni = dni;
	}

	@Override
	protected double aplicarDescuento(double monto) {
		return monto * 0.9;
	}
}
