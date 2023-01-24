package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio9_YHO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cont = 0;
		while (cont<5) {
			System.out.println("Introduce un número: ");
			int num = Integer.valueOf(sc.nextLine());
			
			if (num%3==0) {
				System.out.println(num + " es múltiplo de 3.");
			} else {
				System.out.println("No es múltiplo de 3.");
			}
			cont++;
		}
		System.out.println("Programa finalizado.");
	}
}
