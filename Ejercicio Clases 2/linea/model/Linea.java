package com.linea.model;

import java.util.Objects;

public class Linea {
	public Linea() {
		this.puntoA = new Punto(0,0);
		this.puntoB = new Punto(0,0);
	}
	public Linea(Punto puntoA, Punto puntoB) {
		super();
		this.puntoA = puntoA;
		this.puntoB = puntoB;
	}
	public Punto getPuntoA() {
		return puntoA;
	}
	public void setPuntoA(Punto puntoA) {
		this.puntoA = puntoA;
	}
	public Punto getPuntoB() {
		return puntoB;
	}
	public void setPuntoB(Punto puntoB) {
		this.puntoB = puntoB;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales= this==obj;
		if (!sonIguales && obj != null && obj instanceof Linea) {
			Linea casteo = (Linea) obj;
			sonIguales=Objects.equals(this.puntoA, casteo.puntoA) && Objects.equals(puntoB, casteo.puntoB);
		}
		return sonIguales;
	}
	public void moverDerecha(double moverLinea) {
		this.puntoA.sumarX(moverLinea);
		this.puntoB.sumarY(moverLinea);		
	}
	
	public void moverIzquierda(double moverLinea) {
		this.puntoA.restarX(moverLinea);
		this.puntoB.restarY(moverLinea);	
	}
	
	public void moverArriba(double moverLinea) {
		this.puntoA.sumarY(moverLinea);
		this.puntoB.sumarY(moverLinea);
	}
	
	public void moverAbajo(double moverLinea) {
		this.puntoA.restarY(moverLinea);
		this.puntoB.restarY(moverLinea);
	}
	
	@Override
	public String toString() {
		return "Linea [" + puntoA + "," + puntoB + "]";
	}

	Punto puntoA;
	Punto puntoB;
}
