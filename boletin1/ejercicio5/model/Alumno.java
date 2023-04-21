package collections.boletin1.ejercicio5.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import collections.boletin1.ejercicio5.exception.AlumnoException;

public class Alumno extends Persona {

	private static final int MAYORIA_EDAD = 18;

	public Alumno(String nombre, int edad) {
		super(nombre, edad);
	}

	@Override
	public void enviarMensaje(Persona destino, String mensaje) throws AlumnoException {
		if(mensaje!=null && this.edad >= MAYORIA_EDAD) {
			destino.mensajes.add(new Mensaje(destino,mensaje));
		} else {
			throw new AlumnoException("Error. No cumples la mayoria de edad");
		}
	}

	@Override
	public String leerMensaje() throws AlumnoException {
		if (this.mensajes.isEmpty()) {
			throw new AlumnoException("Error. No hay mensajes.");
		}
		return this.mensajes.toString();
	}

	@Override
	public String leerMensajesOrdenados() throws AlumnoException {
		if (this.mensajes.isEmpty()) {
			throw new AlumnoException("Error. No hay mensajes.");
		}
		Collections.sort(this.mensajes);
		return this.mensajes.toString();
	}

	@Override
	public void borrarMensaje(int mensaje) throws AlumnoException {
		Iterator<Mensaje> it = this.mensajes.iterator();
		boolean entrado=false;
		while (it.hasNext()) {
			if(it.next().getNumeroCodigo()==mensaje) {
				it.remove();
				entrado=true;
			}
		} 
		if(!entrado) {
			throw new AlumnoException("Error.Mensaje no encontrado.");
		}		
	}

	@Override
	public String encontrarMensajeConFrase(String frase) throws AlumnoException {
		List<Mensaje> mensajeconfrase = new ArrayList<>();
		Iterator<Mensaje> it = this.mensajes.iterator();
		
		while(it.hasNext()) {
			if(it.next().getTexto().contains(frase)) {
				mensajeconfrase.add(it.next());
			}
		}
		if (mensajeconfrase.isEmpty()) {
			throw new AlumnoException("Error. No hay mensajes que contenga esta frase.");
		}
		return this.mensajes.toString();
	}

}
