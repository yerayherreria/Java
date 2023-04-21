package collections.boletin1.ejercicio5.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import collections.boletin1.ejercicio5.exception.ProfesorException;

public class Profesor extends Persona {

	public Profesor(String nombre, int edad) {
		super(nombre, edad);
	}

	@Override
	public void enviarMensaje(Persona destino, String mensaje) throws ProfesorException {
		if(mensaje!=null) {
			destino.mensajes.add(new Mensaje(destino,mensaje));
		} else {
			throw new ProfesorException("Error. Mensaje no válido.");
		}
		
	}

	@Override
	public String leerMensaje() throws ProfesorException {
		if (this.mensajes.isEmpty()) {
			throw new ProfesorException("Error. No hay mensajes.");
		}
		return this.mensajes.toString();
	}

	@Override
	public String leerMensajesOrdenados() throws ProfesorException  {
		if (this.mensajes.isEmpty()) {
			throw new ProfesorException("Error. Buzón vacío.");
		}
		Collections.sort(this.mensajes);
		return this.mensajes.toString();
	}

	@Override
	public void borrarMensaje(int mensaje) throws ProfesorException {
		Iterator<Mensaje> it = this.mensajes.iterator();
		boolean entrado=false;
		while (it.hasNext()) {
			if(it.next().getNumeroCodigo()==mensaje) {
				it.remove();
				entrado=true;
			}
		} 
		if(!entrado) {
			throw new ProfesorException("Error.Mensaje no encontrado.");
		}
	}

	@Override
	public String encontrarMensajeConFrase(String frase) throws ProfesorException {
		List<Mensaje> mensajeconfrase = new ArrayList<>();
		Iterator<Mensaje> it = this.mensajes.iterator();
		Mensaje m = null;
		while(it.hasNext()) {
			m = it.next();
			if(m.getTexto().contains(frase)) {
				mensajeconfrase.add(m);
			}
		}
		if (mensajeconfrase.isEmpty()) {
			throw new ProfesorException("Error. No hay mensajes que contenga esta frase.");
		}
		return this.mensajes.toString();
	}

}
