package collections.boletin1.ejercicio5.model;

import java.util.ArrayList;
import java.util.List;

import collections.boletin1.ejercicio5.exception.AlumnoException;
import collections.boletin1.ejercicio5.exception.ProfesorException;

public abstract class Persona {
	protected String nombre;
	protected int edad;
	protected List<Mensaje> mensajes;
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.mensajes = new ArrayList<>();
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public abstract void enviarMensaje(Persona destino,String mensaje) throws AlumnoException, ProfesorException;
	
	public abstract String leerMensaje() throws AlumnoException, ProfesorException;
	
	public abstract String leerMensajesOrdenados() throws AlumnoException, ProfesorException;
	
	public abstract void borrarMensaje(int mensaje) throws ProfesorException, AlumnoException;
	
	public abstract String encontrarMensajeConFrase(String frase) throws ProfesorException, AlumnoException;
}
