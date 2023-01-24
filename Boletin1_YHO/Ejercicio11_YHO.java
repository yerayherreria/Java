package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio11_YHO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=0;
		
		while(num>=0) {
			System.out.println("Introduce un numero: ");
			num = Integer.valueOf(sc.nextLine());
			int cuadrado = num*num;
			if (num>0) {
				System.out.println("El cuadrado es "+cuadrado);
			}
		}
		System.out.println("Fin del programa.");
	}
}