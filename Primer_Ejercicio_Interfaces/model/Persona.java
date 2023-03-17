package enumerados.genero.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona implements Desplazable,Comparable<Persona>{
	
	private String nombre;
	private String apellido;
	private Genero genero;
	private LocalDate fechaNacimiento;
	
	public Persona(String nombre, String apellido, Genero genero, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
	}
	public void moverse() {
		System.out.println("Muevete con soltura sobre todo en la cintura.");
	}
	public void correr() {
		System.out.println("Corre curro que currucu te pilla.");
	}
	public void saltar() {
		System.out.println("Salta como el conejito malo.");
	}
	public void agacharse() {
		System.out.println("Suavesito para abajo,para abajo.");
	}
	public int getEdad() {
		return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}
	public int compareTo(Persona o) {
		return o.genero.compareTo(this.genero);
	}
	@Override
	public String toString() {
		return "Soy " + genero + " y me llamo " + nombre + " " + apellido + " tengo "
				+ getEdad() + "años";
	}
}
