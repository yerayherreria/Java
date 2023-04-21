package collections.boletin1.ejercicio5;

import collections.boletin1.ejercicio5.exception.AlumnoException;
import collections.boletin1.ejercicio5.exception.ProfesorException;
import collections.boletin1.ejercicio5.model.Alumno;
import collections.boletin1.ejercicio5.model.Profesor;

public class Main {

	public static void main(String[] args) {
		Alumno a1 = new Alumno("Curro",21);
		Alumno a2 = new Alumno("Currita",12);
		Profesor p1 = new Profesor("Jose Manuel",46);
		Profesor p2 = new Profesor("Marta",46);
		
		try {
			a1.enviarMensaje(p2, "ola ke ase");
			a1.enviarMensaje(p2, "ola ke ase");
			a1.enviarMensaje(p1, "ola ");
			System.out.println(a1.leerMensajesOrdenados());
		} catch (AlumnoException e) {
			e.printStackTrace();
		}
		
		try {
			p2.enviarMensaje(a2, "ola ke ase");			
			System.out.println(p2.leerMensaje());
			p2.borrarMensaje(0);
		} catch (ProfesorException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(p2.encontrarMensajeConFrase("ola"));
		} catch (ProfesorException e) {
			e.printStackTrace();
		}
	}

}
