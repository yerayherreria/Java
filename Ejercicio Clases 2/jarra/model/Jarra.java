package com.jarra.model;

public class Jarra {
	private double capacidad;
	private double cantidad;
	private static double totalGastado;
	
	public Jarra() {
		this.cantidad = 0.0;
	}
	public Jarra(double capacidad) {
		super();
		this.capacidad = capacidad;
		this.cantidad = 0.0;
	}
	public double getTotalGastado() {
		return totalGastado;
	}
	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public void llenarJarra() {
		this.cantidad=this.capacidad;
		totalGastado+=this.capacidad;
	}
	public void vaciarJarra() {
		this.cantidad=0.0;
	}
	public boolean volcarJarra(Jarra x) {
		boolean resultado = false;
		if(this.cantidad + x.cantidad <= x.capacidad) {
			x.cantidad += this.cantidad;
			this.cantidad = 0.0;
			resultado = true;
		}
		return resultado;
	}
	@Override
	public String toString() {
		return "Jarra [capacidad=" + capacidad + ", cantidad=" + cantidad + "]";
	}
	
}
