package ar.edu.unlp.info.oo1.a;
public class PersonaJuridica extends Cliente {
	private String CUIT;
	private String tipo;

	public PersonaJuridica(String nombre, String direccion, String numero, String CUIT, String tipo) {
		super(nombre, direccion, numero);
		this.CUIT = CUIT;
		this.tipo = tipo;
	}

	@Override
	protected double aplicarDescuento(double monto) {
		return monto * 1;
	}
}
