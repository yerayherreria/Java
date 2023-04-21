package collections.boletin1.ejercicio6Listas.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Diccionario {
	private Set<Descripcion> entrada;

	public Diccionario() {
		super();
		this.entrada = new HashSet<>();
	}
	
	public void anniadirPalabraSignificado(String palabra,String significado) {
		boolean estaPalabra = false;
		Descripcion d = null;
		Iterator<Descripcion> it = this.entrada.iterator();
		if(palabra!=null && significado!=null) {
			while(it.hasNext() && !estaPalabra) {
				if(it.next().getClave().equals(palabra)) {
					estaPalabra=true;
					d=it.next();
				}
			}
			if(estaPalabra) {
				d.setSignificado(significado);
			} else {
				this.entrada.add(new Descripcion(palabra,significado));
			}
		}
	}
	
	public String buscarPalabra(String palabra) {
		boolean estaPalabra = false;
		Descripcion d = null;
		Iterator<Descripcion> it = this.entrada.iterator();
		if(palabra!=null) {
			while(it.hasNext() && !estaPalabra) {
				d=it.next();
				if(it.next().getClave().equals(palabra)) {
					estaPalabra=true;
				}
			}	
		}
		return d.toString();
	}
	
	public void borrarPalabra(String palabra) {
		boolean estaPalabra = false;
		Iterator<Descripcion> it = this.entrada.iterator();
		if(palabra!=null) {
			while(it.hasNext() && !estaPalabra) {
				if(it.next().getClave().equals(palabra)) {
					estaPalabra=true;
					it.remove();
				}
			}	
		}
	}
	
	public List<String> listarPalabra(String cadena) {
		List<String> palabras = new ArrayList<>();
		Iterator<Descripcion> it = this.entrada.iterator();
		Descripcion d = null;
		if(cadena!=null) {
			while(it.hasNext()) {
				d=it.next();
				if(it.next().getClave().startsWith(cadena)) {
					palabras.add(d.getClave());
				}
			}	
		}

		Collections.sort(palabras);
		return palabras;
	}

}
