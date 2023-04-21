package collections.boletin1.ejercicio1;

import java.util.Arrays;

public class ArraysUtils {
	public static <T> T[] reverse ( T[] arrayOriginal) {
		int posicion=0;
		T[] tmp =arrayOriginal.clone();
		for (int i=arrayOriginal.length-1; i>=0; i--) {
			if(arrayOriginal[i]!=null) {
				tmp[posicion++]=arrayOriginal[i];
			}
		}
		return tmp;
	}
	public static void main(String[] args) {
		Integer[] listadoNumeros = {1,2,3,4,5,6,7};
		
		System.out.println(Arrays.toString(reverse(listadoNumeros)));
	}
}
