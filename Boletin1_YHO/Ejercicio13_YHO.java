package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio13_YHO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe un número: ");
		int num = Integer.valueOf(sc.nextLine());
		int cont=0;
		int mayor=num;
		int menor=num;
		
		while(cont<9) {
			if (mayor<num) {
				mayor=num;
			}else if (num<menor) {
				menor=num;
			}
			cont++;
			System.out.println("Escribe un número: ");
			num = Integer.valueOf(sc.nextLine());
		}
		System.out.println("El mayor es "+ mayor);
		System.out.println("El menor es "+ menor);
	}
}