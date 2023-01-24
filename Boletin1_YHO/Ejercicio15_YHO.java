package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio15_YHO {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String palabra="";
		int suma=0;
		do {
			System.out.println("Introduce un número: ");
			int num = Integer.valueOf(sc.nextLine());
			suma+=num;
			System.out.println("¿Desea seguir? (Para acabar escriba fin)");
			palabra = String.valueOf(sc.nextLine());
		}while(!palabra.equals("fin"));
		System.out.println("La suma es " + suma);
	}

}
