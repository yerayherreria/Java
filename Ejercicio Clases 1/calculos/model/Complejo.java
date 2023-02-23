package com.calculos.model;

public class Complejo {
	public Complejo() {}
	public Complejo(double real, double imaginario) {
		super();
		this.real = real;
		this.imaginario = imaginario;
	}
	public double getReal() {
		return real;
	}
	public void setReal(double real) {
		this.real = real;
	}
	public double getImaginario() {
		return imaginario;
	}
	public void setImaginario(double imaginario) {
		this.imaginario = imaginario;
	}
	public Complejo sumar(Complejo c){
        Complejo nuevoC = new Complejo();
        nuevoC.real = real + c.real;
        nuevoC.imaginario = imaginario + c.imaginario;
        return nuevoC;
    }
	public Complejo restar(Complejo c){
        Complejo nuevoC = new Complejo();
        nuevoC.real = real - c.real;
        nuevoC.imaginario = imaginario - c.imaginario;
        return nuevoC;
    }
	public String toString() {
		String resultado = real + " - " + imaginario + " *i";;
		if(imaginario >= 0) {
			resultado = real + " + " + imaginario + " *i";
		}
		return resultado;
    }
	public String mostrarInformacion() {
		return this.real + ", " + this.imaginario;
	}
	private double real;
	private double imaginario;
}
