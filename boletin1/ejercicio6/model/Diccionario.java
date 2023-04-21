package collections.boletin1.ejercicio6.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Diccionario {
	private Map<String, Collection<String>> diccionario;

	public Diccionario() {
		super();
		this.diccionario = new HashMap<>();
	}
	
	public void anniadirPalabraSignificado(String palabra,String significado) {
		if(palabra!=null && significado!=null) {
			if (!this.diccionario.containsKey(palabra)) {
				this.diccionario.put(palabra, new HashSet<>());
			}
			this.diccionario.get(palabra).add(significado);			
		}
	}
	
	public String buscarPalabra(String palabra) {
		StringBuilder sb = new StringBuilder();
		if (palabra!=null && this.diccionario.containsKey(palabra)) {
			for(String s: this.diccionario.get(palabra)) {
				sb.append(s).append("\n");
			}
		}
		return sb.toString();
	}
	
	public void borrarPalabra(String palabra) {
		if (palabra!=null && this.diccionario.containsKey(palabra)) {
			this.diccionario.remove(palabra);
		}
	}
	
	public List<String> listarPalabra(String cadena) {
		List<String> palabras = new ArrayList<>();
		for(String clave: this.diccionario.keySet()) {
			if((clave).startsWith(cadena)) {
				palabras.add(clave);
			}
		}
		Collections.sort(palabras);
		return palabras;
	}

}
