package collections.boletin1.ejercicio2;

import collections.boletin1.ejercicio2.exception.AlumnoException;
import collections.boletin1.ejercicio2.model.Alumno;
import collections.boletin1.ejercicio2.model.Equipo;

public class Main {

	public static void main(String[] args) {
		Equipo e=new Equipo("Los litros");
		Equipo e2=new Equipo("Botellines FC");
		
		Alumno a1 = new Alumno("El nini","12345678A");
		Alumno a2 = new Alumno("Cristo","87654321B");
		Alumno a3 = new Alumno("Camaron","12341234C");
		Alumno a4 = new Alumno("Herreria","43214321D");
		
		System.out.println(a1);
		
		try {
			e.annyadirAlumno(a4);
			e2.annyadirAlumno(a3);
			e2.annyadirAlumno(a2);
			e.annyadirAlumno(a2);
			e2.annyadirAlumno(a1);
		} catch (AlumnoException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(e);
		System.out.println(e2);
		try {
			e.eliminarAlumno(a4);
		} catch (AlumnoException e1) {
			e1.printStackTrace();
		}
		System.out.println(e);
		System.out.println(e.existeAlumno(a4));
		System.out.println(e2.unirEquipos(e));
		System.out.println(e.interseccionEquipo(e2));
	}

}
