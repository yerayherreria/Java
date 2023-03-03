package com.linea;

import java.util.Scanner;

import com.linea.model.Linea;
import com.linea.model.Punto;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu = "1. Mover línea: Solicitará el movimiento (A-arriba, B-ABajo, I-Izquierda, DDerecha) y realice el movimiento\r\n"
				+ "2. Mostrar línea\r\n"
				+ "3. Salir",movimiento="";
		int opcion=0;
		double desplazamiento=0.0;
	
		System.out.println("Di el valor x del primer punto:");
		double x1 = Double.valueOf(sc.nextLine());
		System.out.println("Di el valor x del segundo punto:");
		double x2 = Double.valueOf(sc.nextLine());
		System.out.println("Di el valor y del primer punto:");
		double y1 = Double.valueOf(sc.nextLine());
		System.out.println("Di el valor y del segundo punto:");
		double y2 = Double.valueOf(sc.nextLine());
		
		Punto punto1 = new Punto(x1,y1);
		Punto punto2 = new Punto(x2,y2);
		Linea ln = new Linea(punto1,punto2);
		
		do {
			do {
				System.out.println(menu);
				opcion = Integer.valueOf(sc.nextLine());
			} while (opcion!=1 && opcion!=2 && opcion!=3);
			if (opcion==1) {
				do {
					System.out.println("Introduce el movimiento: (a-b-i-d)");
					movimiento = sc.nextLine();
				} while (!(movimiento.equalsIgnoreCase("a") || movimiento.equalsIgnoreCase("b") || movimiento.equalsIgnoreCase("i") || movimiento.equalsIgnoreCase("d")));
				
				if (movimiento.equalsIgnoreCase("a")) {
					System.out.println("Indica el desplazamiento:");
					desplazamiento = Double.valueOf(sc.nextLine());
					ln.moverArriba(desplazamiento);
				} else if (movimiento.equalsIgnoreCase("b")) {
					System.out.println("Indica el desplazamiento:");
					desplazamiento = Double.valueOf(sc.nextLine());
					ln.moverAbajo(desplazamiento);
				} else if (movimiento.equalsIgnoreCase("i")) {
					System.out.println("Indica el desplazamiento:");
					desplazamiento = Double.valueOf(sc.nextLine());
					ln.moverIzquierda(desplazamiento);
				} else if (movimiento.equalsIgnoreCase("d")) {
					System.out.println("Indica el desplazamiento:");
					desplazamiento = Double.valueOf(sc.nextLine());
					ln.moverDerecha(desplazamiento);
				}
			} else if (opcion==2) {
				System.out.println(ln);
			}
		} while (opcion!=3);
		System.out.println("Programa acabado.");
	}

}
