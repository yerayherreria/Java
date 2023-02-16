package com.edu.avion;

public class Avion {
	//Constructores
	public Avion(String idAvion, int capacidad) {
		super();
		this.idAvion = idAvion;
		this.capacidad = capacidad;
	}
	public Avion(String idAvion, int capacidad, String compannia) {
		super();
		this.capacidad = capacidad;
		this.compannia = compannia;
	}
	//Get and Set
	public String getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(String idAvion) {
		this.idAvion = idAvion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getNumVuelos() {
		return numVuelos;
	}
	public void setNumVuelos(int numVuelos) {
		this.numVuelos = numVuelos;
	}
	public double getKmVolados() {
		return kmVolados;
	}
	public void setKmVolados(double kmVolados) {
		this.kmVolados = kmVolados;
	}
	public String getCompannia() {
		return compannia;
	}
	public void setCompannia(String compannia) {
		this.compannia = compannia;
	}
	//Metodos añadidos
	public boolean asignarVuelo(int capacidad, double kmVolados) {
		if (capacidad<=this.capacidad && kmVolados>0) {
			this.numVuelos++;
			this.kmVolados+=kmVolados;
		}
		return capacidad<=this.capacidad && kmVolados>0;
	}
	public double getTotalKm() {
		return kmVolados;
	}
	public double getMediaKm() {
		return kmVolados/numVuelos;
	}
	
	//Declaracion variables
	private String idAvion;
	private int capacidad;
	private int numVuelos=0;
	private double kmVolados=0;
	private String compannia;
}
