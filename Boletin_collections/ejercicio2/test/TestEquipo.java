package collections.boletin1.ejercicio2.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import collections.boletin1.ejercicio2.exception.AlumnoException;
import collections.boletin1.ejercicio2.model.Alumno;
import collections.boletin1.ejercicio2.model.Equipo;

class TestEquipo {
	Alumno a1= new Alumno("curro","12345678A");
	Alumno a2= new Alumno("manolo","87654321A");
	Alumno a3= new Alumno("chispa","12341234A");
	Equipo e = new Equipo("Los litros");
	Equipo e2 = new Equipo("Los botellines");

	@Test
	void testAnnyadirAlumno() {
		try {
			e.annyadirAlumno(a1);
		} catch (AlumnoException e) {
			assert(false);
		}
	}
	
	@Test
	void testAnnyadirAlumnoKO() {
		try {
			e.annyadirAlumno(null);
		} catch (AlumnoException e) {
			assert(true);
		}
	}
	
	@Test
	void testAnnyadirAlumnoKO2() {
		try {
			e.annyadirAlumno(a1);
			e.annyadirAlumno(a1);
		} catch (AlumnoException e) {
			assert(true);
		}
	}

	@Test
	void testEliminarAlumno() {
		try {
			e.annyadirAlumno(a1);
		} catch (AlumnoException e) {
			assert(false);
		}
		try {
			e.eliminarAlumno(a1);
		} catch (AlumnoException e) {
			assert(false);
		}
	}

	@Test
	void testEliminarAlumnoKO() {
		try {
			e.annyadirAlumno(a1);
		} catch (AlumnoException e) {
			assert(false);
		}
		try {
			e.eliminarAlumno(null);
		} catch (AlumnoException e) {
			assert(true);
		}
	}
	
	@Test
	void testEliminarAlumnoKO2() {
		try {
			e.annyadirAlumno(a1);
		} catch (AlumnoException e) {
			assert(false);
		}
		try {
			e.eliminarAlumno(a1);
			e.eliminarAlumno(a1);
		} catch (AlumnoException e) {
			assert(true);
		}
	}
	
	@Test
	void testExisteAlumno() {
		try {
			e.annyadirAlumno(a1);
		} catch (AlumnoException e) {
			assert(false);
		}
		assertNotEquals(e.existeAlumno(a1),null);
	}
	
	@Test
	void testExisteAlumnoKO() {
		try {
			e.annyadirAlumno(a1);
		} catch (AlumnoException e) {
			assert(false);
		}
		assertFalse(e.existeAlumno(a1).equals(null));
	}

	@Test
	void testUnirEquipos() {
		try {
			e.annyadirAlumno(a1);
			e.annyadirAlumno(a2);
			e2.annyadirAlumno(a2);
			e2.annyadirAlumno(a3);
			e.unirEquipos(e2);
		} catch (AlumnoException e) {
			assert(false);
		}
	}
	
	@Test
	void testUnirEquiposKO() {
		try {
			e.annyadirAlumno(a1);
			e.annyadirAlumno(a2);
			e2.annyadirAlumno(a2);
			e2.annyadirAlumno(a3);
			e.unirEquipos(null);
		} catch (AlumnoException e) {
			assert(true);
		}
	}

	@Test
	void testInterseccionEquipo() {
		try {
			e.annyadirAlumno(a1);
			e.annyadirAlumno(a2);
			e2.annyadirAlumno(a2);
			e2.annyadirAlumno(a3);
			e.interseccionEquipo(e2);
		} catch (AlumnoException e) {
			assert(false);
		};
	}
	
	@Test
	void testInterseccionEquipoKO() {
		try {
			e.annyadirAlumno(a1);
			e.annyadirAlumno(a2);
			e2.annyadirAlumno(a2);
			e2.annyadirAlumno(a3);
			e.interseccionEquipo(null);
		} catch (AlumnoException e) {
			assert(true);
		};
	}
	
	@Test
	void testtoString() {
		assertTrue(e.toString().equals(e.toString()));
	}
}
