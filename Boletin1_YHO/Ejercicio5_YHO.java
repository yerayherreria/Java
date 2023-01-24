package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio5_YHO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hora = 0;
		
		do {
			System.out.println("Introduce la hora");
			hora = Integer.valueOf(sc.nextLine());
		}while(hora<0 || hora>24);
		
		if (hora>=6 && hora<=12) {
			System.out.println("Buenos días.");
		} else if (hora>=13 && hora<=20) {
			System.out.println("Buenas tardes.");
		} else {
			System.out.println("Buenas noches.");
		}	
	}
}
