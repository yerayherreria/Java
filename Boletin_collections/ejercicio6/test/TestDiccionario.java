package collections.boletin1.ejercicio6.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.boletin1.ejercicio6.model.Diccionario;

class TestDiccionario {
	Diccionario d = new Diccionario();
	
	@Test
	void testAnniadirPalabraSignificado() {
		assertTrue(d.buscarPalabra("cc").isEmpty());
		
		d.anniadirPalabraSignificado("hola", "saludo");
		assertFalse(d.buscarPalabra("hola").isEmpty());
	}
	
	@Test
	void testBorrarPalabra() {
		d.anniadirPalabraSignificado("hola", "saludo");
		d.anniadirPalabraSignificado("adios", "saludo");
		
		assertFalse(d.buscarPalabra("hola").isEmpty());
		
		d.borrarPalabra("hola");
		assertTrue(d.buscarPalabra("hola").isEmpty());
		assertFalse(d.buscarPalabra("adios").isEmpty());
	}

	@Test
	void testListarPalabra() {
		d.anniadirPalabraSignificado("hola", "saludo");
		d.anniadirPalabraSignificado("adios", "saludo");
		
		assertTrue(d.listarPalabra("cc").isEmpty());
		assertFalse(d.listarPalabra("hola").isEmpty());
	}

}
