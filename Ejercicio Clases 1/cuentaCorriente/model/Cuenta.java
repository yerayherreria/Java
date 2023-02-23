package com.cuentaCorriente.model;

public class Cuenta {
	public Cuenta() {}
	public Cuenta(double saldo, double ingreso, double retiro) {
		super();
		this.saldo = saldo;
		this.ingreso = ingreso;
		this.retiro = retiro;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getIngreso() {
		return ingreso;
	}
	public void setIngreso(double ingreso) {
		this.ingreso = ingreso;
	}
	public double getRetiro() {
		return retiro;
	}
	public void setRetiro(double retiro) {
		this.retiro = retiro;
	}
	public void ingresarSaldo(double ingresoDinero) {
		if (ingresoDinero>0) {
			this.saldo+=ingresoDinero;
			this.ingreso++;
		}
	}
	public void retirarSaldo(double reintegroDinero) {
		if (this.saldo>reintegroDinero && reintegroDinero>0) {
			this.saldo-=reintegroDinero;
			this.retiro++;
		}
	}
	private double saldo;
	private double ingreso;
	private double retiro;
}
