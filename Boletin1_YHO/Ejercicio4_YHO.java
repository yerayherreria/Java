package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio4_YHO {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double practica=0;
		double problema=0;
		double teorica=0;
		do {
			System.out.println("Introduce la nota de la parte práctica (0-10):");
			practica=Double.valueOf(sc.nextLine());
		}while(practica>=0 || practica<=10);
		do {
			System.out.println("Introduce la nota de la parte de problemas (0-10):");
			problema=Double.valueOf(sc.nextLine());
		}while(problema>=0 || problema<=10);
		do {
			System.out.println("Introduce la nota de la parte teórica (0-10):");
			teorica=Double.valueOf(sc.nextLine());
		}while(teorica>=0 || teorica<=10);
		
		double nota = ((practica*0.1) + (practica*0.5) + (practica*0.4));
		System.out.println(nota);
		if (nota>=0 && nota<5) {
			System.out.println("La nota es Insuficiente.");
		} else if (nota>=5 && nota<=5.5) {
			System.out.println("La nota es Suficiente.");
		} else if (nota>=5.6 && nota<=6.5) {
			System.out.println("La nota es Bien.");
		} else if (nota>=6.6 && nota<=8.5) {
			System.out.println("La nota es Notable.");
		} else if (nota>=8.6 && nota<=10) {
			System.out.println("La nota es de Sobresaliente.");
		} else {
			System.out.println("Nota no válida.");
			}
	}
}