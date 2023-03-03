package com.producto.model;

import java.util.Objects;

public class Producto {
	
	private String descripcion;
	private double precioSinIVA;
	final static double IVA = 0.2;
	
	public Producto() {}
	public Producto(String descripcion, double precioSinIVA) {
		super();
		this.descripcion = descripcion;
		this.precioSinIVA = precioSinIVA;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioSinIVA() {
		return precioSinIVA;
	}
	public void setPrecioSinIVA(double precioSinIVA) {
		this.precioSinIVA = precioSinIVA;
	}
	public double precioVenta() {
		return this.precioSinIVA+(this.precioSinIVA * IVA);
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, precioSinIVA);
	}
	@Override
	public String toString() {
		return "Producto con descripcion=" + descripcion + " y precioSinIVA=" + precioSinIVA + " tiene el codigo="+hashCode();
	}
	
}
