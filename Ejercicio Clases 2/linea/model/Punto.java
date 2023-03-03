package com.linea.model;

public class Punto {
	public Punto() {}
	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void restarX(double cantidad) {
		this.x-=cantidad;
	}
	public void sumarX(double cantidad) {
		this.x+=cantidad;
	}
	public void restarY(double cantidad) {
		this.y-=cantidad;
	}
	public void sumarY(double cantidad) {
		this.y+=cantidad;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	private double x;
	private double y;
}
