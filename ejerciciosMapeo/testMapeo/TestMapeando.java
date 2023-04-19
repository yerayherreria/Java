package collections.ejerciciosMapeo.testMapeo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import collections.ejerciciosMapeo.model.Genero;
import collections.ejerciciosMapeo.model.Mapeando;
import collections.ejerciciosMapeo.model.Persona;

class TestMapeando {
	Mapeando m = new Mapeando();
	List<Persona> personas = new ArrayList<>();
	List<Integer> numeros = new ArrayList<>();
	
	@Test
	void testMapearPersonasPorGenero() {
		personas.add(new Persona("yeray","herreria",Genero.MASCULINO));
		personas.add(new Persona("jose","sevillano",Genero.MASCULINO));
		personas.add(new Persona("ana","lopez",Genero.FEMENINO));
		personas.add(new Persona("maria","martinez",Genero.FEMENINO));
		personas.add(new Persona("teresa","currero",Genero.DESCONOCIDO));
		personas.add(new Persona("manolo","vitien",Genero.NEUTRO));
		assertTrue(m.mapearPersonasPorGenero(personas).containsKey(Genero.FEMENINO));
		assertTrue(m.mapearPersonasPorGenero(personas).containsKey(Genero.MASCULINO));
		assertTrue(m.mapearPersonasPorGenero(personas).containsKey(Genero.DESCONOCIDO));
		assertTrue(m.mapearPersonasPorGenero(personas).containsKey(Genero.NEUTRO));
		assertFalse(m.mapearPersonasPorGenero(personas).isEmpty());
	}
	
	@Test
	void testMapearPersonasPorGeneroKO() {
		assertFalse(m.mapearPersonasPorGenero(personas).containsKey(Genero.FEMENINO));
		assertFalse(m.mapearPersonasPorGenero(personas).containsKey(Genero.MASCULINO));
		assertFalse(m.mapearPersonasPorGenero(personas).containsKey(Genero.DESCONOCIDO));
		assertFalse(m.mapearPersonasPorGenero(personas).containsKey(Genero.NEUTRO));
		assertTrue(m.mapearPersonasPorGenero(personas).isEmpty());	
	}

	@Test
	void testContarNumeros() {		
		numeros.add(1);
		numeros.add(4);
		numeros.add(3);
		numeros.add(3);
		numeros.add(1);
		numeros.add(5);
		numeros.add(2);	
		assertTrue(m.contarNumeros(numeros).containsKey(4));	
		assertFalse(m.contarNumeros(numeros).isEmpty());	
	}
	
	@Test
	void testContarNumerosKO() {
		assertFalse(m.contarNumeros(numeros).containsKey(4));	
		assertTrue(m.contarNumeros(numeros).isEmpty());	
	}

}
