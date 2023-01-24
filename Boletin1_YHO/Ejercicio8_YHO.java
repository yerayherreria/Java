package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio8_YHO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cont = 0;
		int suma = 0;
		while (cont<15) {
			System.out.println("Escribe un número: ");
			int num = Integer.valueOf(sc.nextLine());
			suma+=num;
			cont++;
		}		
		System.out.println(suma);
	}
}
