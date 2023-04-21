package collections.boletin1.ejercicio8.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import collections.boletin1.ejercicio2.exception.AlumnoException;

public class Equipo<T> {
	
	private static final int MAYORIA_EDAD = 18;
	private String nombreEquipo;
	Set<Alumno> listaAlumnos = new HashSet<>();
	
	public Equipo(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
	}
	
	public void annyadirAlumno(Alumno a) throws AlumnoException {
		if(a!=null && existeAlumno(a)==null) {
			this.listaAlumnos.add(a);
		} else {
			throw new AlumnoException("Error. El alumno ya existe.");
		}
	}
	
	public void eliminarAlumno(Alumno a) throws AlumnoException {
		if(a!=null && existeAlumno(a)!=null) {
			this.listaAlumnos.remove(a);
		} else {
			throw new AlumnoException("Error. El alumno no existe.");
		}
	}
	
	public Alumno existeAlumno(Alumno a) {
		Alumno alumno=null;
		if(a!=null && this.listaAlumnos.contains(a)) {
			alumno=a;
		}
		return alumno;
	}
	
	public Equipo unirEquipos(Equipo e) {
		if(e!=null && !this.listaAlumnos.equals(e.listaAlumnos)) {
			this.listaAlumnos.addAll(e.listaAlumnos);
		}
		return this;
	}
	
	public Set<Alumno> interseccionEquipo(Equipo e) {
		Set<Alumno> interseccion = new HashSet<>(this.listaAlumnos);
		if(e!=null) {
			interseccion.retainAll(e.listaAlumnos);
		}
		return interseccion;

	}

	@Override
	public String toString() {
		return "El equipo " + this.nombreEquipo + " tiene estos jugadores " + this.listaAlumnos.toString() + ".";
	}
	
	public String listadoJugadoresMasculinos() {
		List<Alumno> listaAlumnos = new ArrayList<>();
		for(Alumno a: this.listaAlumnos) {
			listaAlumnos.add(a);
		}
		
		Collections.sort(listaAlumnos);
		StringBuilder sb = new StringBuilder();
		for(Alumno a : listaAlumnos) {
			if((a.getSexo()=='H' || a.getSexo()=='a') && a.getEdad()>=MAYORIA_EDAD) {
				sb.append(a).append("\n");
			}
		}
		return sb.toString();
	}
	
	public boolean esFemenino() {
		boolean es = true;
		for(Alumno a: this.listaAlumnos) {
			if(a.getSexo()=='H' || a.getSexo()=='h') {
				es = false;
			}
		}
		return es;
	}
	
	public int jugadorasMayor() {
		int cont = 0;
		for(Alumno a: this.listaAlumnos) {
			if((a.getSexo()=='M' || a.getSexo()=='m') && a.getEdad()>=MAYORIA_EDAD) {
				cont++;
			}
		}
		return cont;
	}
	
	public int jugadoraMayor() {
		int edad = 0;
		for(Alumno a: this.listaAlumnos) {
			if(a.getEdad()>edad) {
				edad=a.getEdad();
			}
		}
		return edad;
	}
	
	public Set<String> jugadoresMenores() {
		Set<String> dni = new HashSet<>();
		for(Alumno a: this.listaAlumnos) {
			if(a.getSexo()=='H' || a.getSexo()=='h' && a.getEdad()<MAYORIA_EDAD) {
				dni.add(a.getDni());
			}
		}
		return dni;
	}
	
	public List<String> nombreAscendente(){
		List<String> nombres = new ArrayList<>();
		for(Alumno a: this.listaAlumnos) {
			if(a.getSexo() == 'M' || a.getSexo() == 'm') {
				nombres.add(a.getNombre());
			}
		}
		Collections.sort(nombres);
		
		return nombres;
	}
	
	public boolean hayJugadoraMayor() {
		boolean es = false;
		for(Alumno a: this.listaAlumnos) {
			if((a.getSexo()=='M' || a.getSexo()=='m') && a.getEdad()>=MAYORIA_EDAD) {
				es=true;
			}
		}
		return es;
	}

	public int ciudadesDistintas() {
		 Set<String> ciudades = new HashSet<>();
		 for(Alumno a : this.listaAlumnos) {
		    ciudades.add(a.getCiudad());
		 }
         	return ciudades.size();
	}
}
