package oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta {

	public CajaDeAhorro() {
		super();
	}

	@Override
	protected boolean puedeExtraer(double monto) {
		return monto <= this.getSaldo();
	}
	@Override
	public boolean extraer(double monto) {
		return super.extraer(monto * 1.02);
	}
	@Override 
	public void depositar(double monto) {
		super.depositar(monto * 0.98);
	}
	@Override 
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		return super.transferirACuenta(monto * 1.02, cuentaDestino);
	}
	
}
