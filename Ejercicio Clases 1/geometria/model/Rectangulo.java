package com.geometria.model;

public class Rectangulo {
	public Rectangulo() {
	}
	public Rectangulo(int longitud, int ancho) {
		super();
		this.longitud = longitud;
		this.ancho = ancho;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		if (longitud>0 && longitud<20) {
			this.longitud = longitud;
		}
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		if (ancho>0 && ancho<20) {
			this.ancho = ancho;
		}
	}
	public int calcularPerimetro(int longitud,int ancho) {
		return (2*(longitud+ancho));
	}
	public double calcularArea(int longitud, int ancho) {
		int resultado = 0;
		if ((ancho > 0 && ancho <=20) && (longitud>0 && longitud <=20)) {
			resultado = ancho * longitud;
		}
		return resultado;
	}
	private int longitud=1;
	private int ancho=1;
}
