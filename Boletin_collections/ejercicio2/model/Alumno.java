package collections.boletin1.ejercicio2.model;

import java.util.Objects;

public class Alumno {

	private String nombre;
	private String dni;
	
	public Alumno(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj && obj!=null;
		
		if (!sonIguales && obj instanceof Alumno) {
			Alumno other = (Alumno) obj;
			sonIguales = Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);			
		}
		return sonIguales;
	}
	
	@Override
	public String toString() {
		return "El alumno " + nombre + " tiene el DNI " + dni + ".";
	}
	
	
}
