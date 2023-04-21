package collections.boletin1.ejercicio2.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import collections.boletin1.ejercicio2.exception.AlumnoException;

public class Equipo<T> {
	
	private String nombreEquipo;
	Set<T> listaAlumnos = new HashSet<>();
	
	public Equipo(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
	}
	
	public void annyadirAlumno(T a) throws AlumnoException {
		if(a!=null && existeAlumno(a)==null) {
			this.listaAlumnos.add(a);
		} else {
			throw new AlumnoException("Error. El alumno ya existe.");
		}
	}
	
	public void eliminarAlumno(T a) throws AlumnoException {
		if(a!=null && existeAlumno(a)!=null) {
			this.listaAlumnos.remove(a);
		} else {
			throw new AlumnoException("Error. El alumno no existe.");
		}
	}
	
	public T existeAlumno(T a) {
		T alumno=null;
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
	
	public Set<T> interseccionEquipo(Equipo e) {
		Set<T> interseccion = new HashSet<>(this.listaAlumnos);
		if(e!=null) {
			interseccion.retainAll(e.listaAlumnos);
		}
		return interseccion;

	}

	@Override
	public String toString() {
		return "El equipo " + this.nombreEquipo + " tiene estos jugadores " + this.listaAlumnos.toString() + ".";
	}
	
}
