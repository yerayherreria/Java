package collections.boletin1.ejercicio8.model;

import java.util.Objects;

public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private String dni;
	private int edad;
	private char sexo;
	private String ciudad;
	
	public Alumno(String nombre, String dni, int edad, char sexo, String ciudad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.sexo = sexo;
		this.ciudad = ciudad;
	}

	public char getSexo() {
		return sexo;
	}
	
	public int getEdad() {
		return edad;
	}	

	public String getCiudad() {
		return ciudad;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
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

	@Override
	public int compareTo(Alumno arg0) {
		return this.edad - arg0.edad;
	}

	
	
}
