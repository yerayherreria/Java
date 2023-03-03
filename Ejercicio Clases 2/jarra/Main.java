package com.jarra;

import java.util.Scanner;

import com.jarra.model.Jarra;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		String jarraOpcion="",menu = "1. Llenar jarra: Se solicitará con la pregunta “¿Qué jarra desea llenar (A/B)?” y\r\n"
				+ "se llenará la jarra correspondiente.\r\n"
				+ "2. Vaciar jarra: Se realizará la pregunta “¿Qué jarra desea vaciar (A/ B)?” y se\r\n"
				+ "vaciará la jarra correspondiente.\r\n"
				+ "3. Volcar jarra A en B .\r\n"
				+ "4. Volcar jarra B en A.\r\n"
				+ "5. Ver estado de las jarras: Se mostrará la capacidad y el agua que contiene, tanto\r\n"
				+ "para la jarra A como para la B.\r\n"
				+ "6. Salir: Cuando salga debe mostrarse un mensaje que indique \"El total de agua\r\n"
				+ "que se ha gastado llenando jarras es XXX litros\".\r\n";
		
		//Creación de las jarras A/B.
		System.out.println("Capacidad de la Jarra A:");
		Jarra a = new Jarra(Double.valueOf(sc.nextLine()));
		System.out.println("Capacidad de la Jarra B:");
		Jarra b = new Jarra(Double.valueOf(sc.nextLine()));
		
		//Menu
		do {
			do {
				System.out.println(menu);
				System.out.println("Selecione una opcion:");
				opcion = Integer.valueOf(sc.nextLine());
			} while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 && opcion!=6);
			
			if (opcion==1) {
				do {
					System.out.println("¿Qué jarra desea llenar (A/B)?");
					jarraOpcion = sc.nextLine();
				} while (!(jarraOpcion.equalsIgnoreCase("a") || jarraOpcion.equalsIgnoreCase("b")));
				
				if (jarraOpcion.equalsIgnoreCase("a")) {
					a.llenarJarra();
				} else if (jarraOpcion.equalsIgnoreCase("b")) {
					b.llenarJarra();
				} else {
					System.out.println("Error, esa jarra no existe");
				}
			} else if (opcion==2) {
				do {
					System.out.println("¿Qué jarra desea vaciar (A/B)?");
					jarraOpcion = sc.nextLine();
				} while (!(jarraOpcion.equalsIgnoreCase("a") || jarraOpcion.equalsIgnoreCase("b")));
				
				if (jarraOpcion.equalsIgnoreCase("a")) {
					a.vaciarJarra();
				} else if (jarraOpcion.equalsIgnoreCase("b")) {
					b.vaciarJarra();
				} else {
					System.out.println("Error, esa jarra no existe");
				}
			} else if (opcion==3) {
				a.volcarJarra(b);
			} else if (opcion==4) {
				b.volcarJarra(a);
			} else if (opcion==5) {
				System.out.println(a);
				System.out.println(b);
			}
		} while (opcion!=6);
		System.out.println("El total de agua que se ha gastado llenando jarras es "+a.getTotalGastado()+" litros.");
		System.out.println("Programa finalizado.");
	}

}
