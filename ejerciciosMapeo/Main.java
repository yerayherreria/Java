package collections.ejerciciosMapeo;

import java.util.ArrayList;
import java.util.List;

import collections.ejerciciosMapeo.model.Genero;
import collections.ejerciciosMapeo.model.Mapeando;
import collections.ejerciciosMapeo.model.Persona;


public class Main {

	public static void main(String[] args) {
		List<Persona> personas = new ArrayList<>();
		Mapeando m = new Mapeando();
		personas.add(new Persona("yeray","herreria",Genero.MASCULINO));
		personas.add(new Persona("jose","sevillano",Genero.MASCULINO));
		personas.add(new Persona("ana","lopez",Genero.FEMENINO));
		personas.add(new Persona("maria","martinez",Genero.FEMENINO));
		personas.add(new Persona("teresa","currero",Genero.DESCONOCIDO));
		personas.add(new Persona("manolo","vitien",Genero.NEUTRO));

		System.out.println(m.mapearPersonasPorGenero(personas));
		//System.out.println(m.generarNumerosAleatorios(20));
		
		List<Integer> numeros = new ArrayList<>();
		
		numeros.add(1);
		numeros.add(4);
		numeros.add(3);
		numeros.add(3);
		numeros.add(1);
		numeros.add(5);
		numeros.add(2);
		System.out.println(m.contarNumeros(numeros));
	}

}
