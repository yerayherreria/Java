package collections.boletin1.ejercicio6Listas.model;

import java.util.HashSet;
import java.util.Set;

public class Descripcion {
	private String clave;
	private Set<String> significado;
	
	public Descripcion(String clave, String significado) {
		super();
		this.significado = new HashSet<>();
		this.clave = clave;
		this.significado.add(significado);
	}

	public String getClave() {
		return clave;
	}

	public void setSignificado(String significado) {
		this.significado.add(significado);
	}

	@Override
	public String toString() {
		return this.significado.toString();
	}
	
	
	
}
