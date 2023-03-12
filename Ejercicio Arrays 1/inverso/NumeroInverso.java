package arrays.inverso;

import java.util.Scanner;

public class NumeroInverso {

	public static void main(String[] args) {
		//ejercicio 1
		Scanner sc = new Scanner(System.in);
		int numeros[] = new int[10];
		for(int i = 0; i < numeros.length ; i++) {
			System.out.println("Introduce un número entero:");
			numeros[i] = Integer.valueOf(sc.nextLine());
		}for(int i = numeros.length-1; i >= 0; i--) {
			System.out.println(numeros[i]);
		}
	}

}
