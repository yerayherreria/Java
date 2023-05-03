package ficheros.euromillon.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class Combinacion {
	
	private static final int VALOR_MAXIMO_ESTRELLAS = 12;
	private static final int VALOR_MAXIMO_NUMEROS = 50;
	private static final int VALOR_MINIMO = 1;
	private static final int NUMERO_MAXIMO_ESTRELLAS = 2;
	private static final int NUMERO_MAXIMO_NUMEROS = 5;
	

	private Set<Integer> numeros;
	private Set<Integer> estrellas;
	
	public Combinacion(int n1, int n2, int n3, int n4, int n5, int e1, int e2) throws CombinacionException {
		super();
		numeros = new HashSet<>();
		numeros.add(n1);
		numeros.add(n2);
		numeros.add(n3);
		numeros.add(n4);
		numeros.add(n5);
		estrellas =  new HashSet<>();
		estrellas.add(e1); 
		estrellas.add(e2);
		
		validarDatos();
		
	}
	
	public Combinacion(String[] numeros,String[] estrellas) throws CombinacionException {
		this(toIntArrays(numeros),toIntArrays(estrellas));
	}

	private static int[] toIntArrays(String[] numeros) {
		int[] n = new int[numeros.length];
		for(int i=0;i<numeros.length;i++) {
			n[i]=Integer.valueOf(numeros[i]);
		}
		return n;
	}


	private void validarDatos() throws CombinacionException {
		if(numeros.size()<NUMERO_MAXIMO_NUMEROS) {
			throw new CombinacionException("Existen números repetidos");
		}
		if(estrellas.size()<NUMERO_MAXIMO_ESTRELLAS) {
			throw new CombinacionException("Existen estrellas repetidas");
		}
		
		for(int n : numeros) {
			if(n>VALOR_MAXIMO_NUMEROS || n < VALOR_MINIMO) {
				throw new CombinacionException("El valor de números no es correcto.");
			}
		}
		
		for(int e : estrellas) {
			if(e>VALOR_MAXIMO_ESTRELLAS || e < VALOR_MINIMO) {
				throw new CombinacionException("El valor de estrellas no es correcto.");
			}
		}
	}
	
	
	public Combinacion(int[] numeros, int[] estrellas) throws CombinacionException {
		this(numeros[0], numeros[1], numeros[2], numeros[3], numeros[4], estrellas[0], estrellas[1]);
	}
	
	public int comprobarCombinacion(Combinacion otra) {
		
		
		/*int coincidencias = 0;
		
		for(int i : numeros) {
			if(otra.getNumeros().contains(i)) {
				coincidencias++;
			}
		}
		
		for(int i : estrellas) {
			if(otra.getEstrellas().contains(i)) {
				coincidencias++;
			}
		}*/
		
		
		Set<Integer> numerosTemporal = new HashSet<>(numeros);
		Set<Integer> estrellasTemporal = new HashSet<>(estrellas);
		numerosTemporal.retainAll(otra.getNumeros());
		estrellasTemporal.retainAll(otra.getEstrellas());
		
		return numerosTemporal.size()+estrellasTemporal.size();
	}

	
	

	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}



	@Override
	public boolean equals(Object obj) {
		return this==obj | 
				obj!=null && obj instanceof Combinacion c
				&& obj.hashCode()==this.hashCode()
				//&& Objects.equals(estrellas, c.estrellas)
				//&& Objects.equals(numeros, c.numeros)
				;
		
	}



	public Set<Integer> getNumeros() {
		return numeros;
	}



	public Set<Integer> getEstrellas() {
		return estrellas;
	}
	
	
	public String toString() {
		return String.format("Combinación formada por números %s y estrellas %s", 
							this.numeros, this.estrellas);
	}
	
}
