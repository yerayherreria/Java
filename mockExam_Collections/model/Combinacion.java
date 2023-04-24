package collections.mockExam_Collections.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import collections.mockExam_Collections.exception.CombinacionException;

public class Combinacion {
	protected static final int VALOR_MINIMO 		  = 1;
	protected static final int VALOR_MAXIMO_NUMEROS	  = 50;
	protected static final int VALOR_MAXIMO_ESTRELLAS = 12;
	protected static final int TOTAL_NUMEROS		  = 5;
	protected static final int TOTAL_ESTRELLAS 		  = 2;
	
	private Set<Integer> numeros;
	private Set<Integer> estrellas;
	
	public Combinacion(int num1,int num2,int num3,int num4,int num5,int estr1,int estr2) throws CombinacionException {
		this(toArray(num1,num2,num3,num4,num5),toArray(estr1,estr2));
	}

	public Combinacion(int[] numeros, int[] estrellas) throws CombinacionException {
		this.numeros = new HashSet<>();
		this.estrellas = new HashSet<>();
		
		for (Integer i: numeros) {
			if(i>=VALOR_MINIMO && i<=VALOR_MAXIMO_NUMEROS) {
				this.numeros.add(i);
			} else {
				throw new CombinacionException("Error.El número no esta entre 1 y 50.");
			}
		}
		for (Integer i: estrellas) {
			if(i>=VALOR_MINIMO && i<=VALOR_MAXIMO_ESTRELLAS) {
				this.estrellas.add(i);
			} else {
				throw new CombinacionException("Error.El número no esta entre 1 y 12.");
			}
		}
		if(this.estrellas.size()!=TOTAL_ESTRELLAS) {
			throw new CombinacionException("Error.Tamaño de estrellas no válido.");
		}
		if(this.numeros.size()!=TOTAL_NUMEROS) {
			throw new CombinacionException("Error.Tamaño de números no válido.");
		}
	}
	
	private static int[] toArray(int...enteros) {
		return enteros;
	}

	public Set<Integer> getNumeros() {
		return this.numeros;
	}

	public Set<Integer> getEstrellas() {
		return this.estrellas;
	}
	
	public int comprobarCombinacion(Combinacion c) {
		int acierto=0;
		if (c!=null) {
			for (Integer i: this.numeros) {
				if(c.numeros.contains(i)) {
					acierto++;
				}
			}
			for (Integer i: this.estrellas) {
				if(c.estrellas.contains(i)) {
					acierto++;
				}
			}
		}
		return acierto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj && obj == null;
		
		if (!sonIguales && obj instanceof Combinacion) {
			Combinacion other = (Combinacion) obj;
			sonIguales = Objects.equals(estrellas, other.estrellas) && Objects.equals(numeros, other.numeros);			
		}
		return sonIguales;
	}

	@Override
	public String toString() {
		return "Combinacion de numeros " + this.numeros + " y de estrellas " + this.estrellas;
	}
	
	
}
