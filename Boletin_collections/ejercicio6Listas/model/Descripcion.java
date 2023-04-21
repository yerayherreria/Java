package collections.boletin1.ejercicio6Listas.model;

import java.util.HashSet;
import java.util.Set;

public class Descripcion {
	private String clave;
	private Set<String> significados;
	
	public Descripcion(String clave, String significado) {
		super();
		this.significados = new HashSet<>();
		this.clave = clave;
		this.significados.add(significado);
	}

	public String getClave() {
		return clave;
	}

	public void setSignificado(String significado) {
		this.significados.add(significado);
	}

	@Override
	public String toString() {
		return this.significados.toString();
	}
	
	
	
}
