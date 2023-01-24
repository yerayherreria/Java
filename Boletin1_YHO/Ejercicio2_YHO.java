package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio2_YHO {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un numero:");
		String dia=String.valueOf(sc.nextLine());
		
		switch (dia) {
		case "LUNES": {
			System.out.println("Base de datos");
			break;
		}
		case "MARTES","MIERCOLES","VIERNES": {
			System.out.println("Programación");
			break;
		}
		case "JUEVES": {
			System.out.println("FOL");
			break;
		}
		default:
			System.out.println("No hay clase.");
			break;
		}
	}

}
