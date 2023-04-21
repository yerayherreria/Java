package collections.boletin1.ejercicio8;

import collections.boletin1.ejercicio2.exception.AlumnoException;
import collections.boletin1.ejercicio8.model.Alumno;
import collections.boletin1.ejercicio8.model.Equipo;

public class Main {

	public static void main(String[] args) {
		Equipo e=new Equipo("Los litros");
		Equipo e2=new Equipo("Botellines FC");

		Alumno a1 = new Alumno("cc", "12345678A",19,'H',"Cordoba");
		Alumno a2 = new Alumno("aa", "12345678B",20,'M',"Almería");
		Alumno a3 = new Alumno("bb", "12345678C",25,'H',"Sevilla");
		Alumno a4 = new Alumno("dd", "12345678D",35,'M',"Huelva");
		Alumno a5 = new Alumno("ff", "12345678F",54,'M',"Sevilla");
		Alumno a6 = new Alumno("gg", "12345678G",67,'H',"Córdoba");
		Alumno a7 = new Alumno("hh", "12345678H",17,'H',"Málaga");
		try {
			e.annyadirAlumno(a1);
			e.annyadirAlumno(a2);
			e.annyadirAlumno(a3);
			e.annyadirAlumno(a4);
			e.annyadirAlumno(a5);
			e.annyadirAlumno(a6);
			e.annyadirAlumno(a7);
			e.annyadirAlumno(a4);
			e.annyadirAlumno(a5);
			e2.annyadirAlumno(a5);
		} catch (AlumnoException e1) {
			e1.printStackTrace();
		}
		
		
		System.out.println(e.listadoJugadoresMasculinos());
		System.out.println(e.esFemenino());	
		System.out.println(e.jugadorasMayor());
		System.out.println(e.jugadoraMayor());
		System.out.println(e.jugadoresMenores());
		System.out.println(e.nombreAscendente());
		System.out.println(e.hayJugadoraMayor());
		System.out.println(e.ciudadesDistintas());
	}

}
