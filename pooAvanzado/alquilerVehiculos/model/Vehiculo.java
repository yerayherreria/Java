package alquilerVehiculos.model;

import java.util.Objects;

import blocNota.model.Nota;

public class Vehiculo {
	private String matricula;
	private Gama gama;
	protected double precioBase;
	

	
	public Vehiculo(String matricula, Gama gama) {
		super();
		this.matricula = matricula;
		this.gama = gama;
		this.precioBase = gama.getPrecioBase();
	}

	public String getMatricula() {
		return matricula;
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj && obj == null;
		if (!sonIguales && obj instanceof Nota) {
			Vehiculo other = (Vehiculo) obj;
			sonIguales = gama == other.gama && Objects.equals(matricula, other.matricula)
					&& Double.doubleToLongBits(precioBase) == Double.doubleToLongBits(other.precioBase);
		}
		return sonIguales;
	}

	@Override
	public String toString() {
		return "El " + getClass().getSimpleName() + " con matricula " + matricula + ", gama " + gama + " con precio de " + precioBase + "€ ";
	}

	
}
