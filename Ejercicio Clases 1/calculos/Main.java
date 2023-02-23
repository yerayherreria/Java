package com.calculos;

import java.util.Scanner;

import com.calculos.model.Complejo;

public class Main {

	public static void main(String[] args) {
		Complejo c=new Complejo();
		Scanner sc=new Scanner(System.in);
		System.out.println(c.sumar(c));
		System.out.println(c.mostrarInformacion());
		String menu="1. Sumar complejos.\n"
				+ "2. Restar complejos.\n"
				+ "3. Salir.";
		int opcion=0;
		
		do {
			do {
				System.out.println(menu);
				System.out.println("Elige la opcion");
				opcion=Integer.valueOf(sc.nextLine());
			} while (opcion!=1 && opcion!=2 && opcion!=3);
			
			if (opcion==1) {
				System.out.println("Introduce el primer real:");
				int real=Integer.valueOf(sc.nextLine());
				System.out.println("Introduce el segundo real:");
				int real2=Integer.valueOf(sc.nextLine());
				System.out.println("Introduce el primer imaginario:");
				int imaginario=Integer.valueOf(sc.nextLine());
				System.out.println("Introduce el segundo imaginario:");
				int imaginario2=Integer.valueOf(sc.nextLine());
				Complejo c1=new Complejo(real,imaginario);
				Complejo c2=new Complejo(real2,imaginario2);
				System.out.println(c1.sumar(c2));
			} else if (opcion==2) {
				System.out.println("Introduce el primer real:");
				int real=Integer.valueOf(sc.nextLine());
				System.out.println("Introduce el segundo real:");
				int real2=Integer.valueOf(sc.nextLine());
				System.out.println("Introduce el primer imaginario:");
				int imaginario=Integer.valueOf(sc.nextLine());
				System.out.println("Introduce el segundo imaginario:");
				int imaginario2=Integer.valueOf(sc.nextLine());
				Complejo c1=new Complejo(real,imaginario);
				Complejo c2=new Complejo(real2,imaginario2);
				System.out.println(c1.restar(c2));
			}
		} while (opcion!=3);
		System.out.println("Fin del programa.");
	}
}
