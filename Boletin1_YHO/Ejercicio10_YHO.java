package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio10_YHO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=0;
		do {
			System.out.println("Introduce el número: (Numero Positivo)");
			num = Integer.valueOf(sc.nextLine());
		}while(num<0);
		
		int suma=0;
		for (int i=num;i<num+100;i++) {
			System.out.println(suma+=i);
		}
	}
}
