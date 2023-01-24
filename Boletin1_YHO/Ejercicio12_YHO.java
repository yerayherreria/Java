package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio12_YHO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cont=-1;
		int num=0;
		while(num>=0) {
			System.out.println("Escribe un número: ");
			num = Integer.valueOf(sc.nextLine());
			cont++;
		}
		System.out.println("Ha introducido usted "+ cont);
	}
}

