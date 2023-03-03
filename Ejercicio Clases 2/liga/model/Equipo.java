package com.liga.model;

public class Equipo {
	private String nombreEquipo;
	
	public Equipo() {}
	public Equipo(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
	}
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	@Override
	public String toString() {
		return nombreEquipo;
	}
}
