package com.edu.avion;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcion2="",identificador="",compannia="",compAntigua="",compNueva="";	
		int capacidad=0,opcion=0;
		double distancia=0;
		Avion a= new Avion(identificador,capacidad,compannia);
		String menu1="Bienvenido!"
				+ ""
				+ "\n 1. Crear avión solo con el identificador."
				+ "\n 2. Crear avión con el identificador y la compañia."
				+ "\n 3. Salir.";
		String menu2="Continuamos:"
				+ ""
				+ "\n a) Asignar Vuelo:"
				+ "\n b) Obtener el número de vuelos:"
				+ "\n c) Obtener el número de kilómetros:"
				+ "\n d) Obtener la media de Kilómetros por vuelo:"
				+ "\n e) Cambio de compañia:"
				+ "\n f) Mostrar información del avión:"
				+ "\n g) Salir";
		
		//Empezamos con el primer menu.
		System.out.println(menu1);
		
		opcion = Integer.valueOf(sc.nextLine());
		
		if (opcion==1) {
			System.out.println("Introduce el identificador del avion:");
			identificador = sc.nextLine();
			System.out.println("Introduce la capacidad del avion:");
			capacidad = Integer.valueOf(sc.nextLine());
			a = new Avion(identificador,capacidad);
		} else if (opcion==2) {
			System.out.println("Introduce el identificador del avion:");
			identificador = sc.nextLine();
			System.out.println("Introduce la capacidad del avion:");
			capacidad = Integer.valueOf(sc.nextLine());
			System.out.println("Introduce la compañia del avion:");
			compannia = sc.nextLine();
			a = new Avion(identificador,capacidad,compannia);
		}
		
		System.out.println(menu2);
		//Segundo menu
		do {
			opcion2=sc.nextLine().toLowerCase();
			if (opcion2.equals("a")) {
				System.out.println("Introduce el numero de asientos:");
				capacidad = Integer.valueOf(sc.nextLine());
				System.out.println("Introduce los km de distacia:");
				distancia = Double.valueOf(sc.nextLine());
				System.out.println(a.asignarVuelo(capacidad, distancia));
			} else if (opcion2.equals("b")) {
				System.out.println(a.getNumVuelos());
			} else if (opcion2.equals("c")) {
				System.out.println(a.getTotalKm());
			} else if (opcion2.equals("d")) {
				System.out.println(a.getMediaKm());
			} else if (opcion2.equals("e")) {
				System.out.println("Introduce tu compañia:");
				compAntigua= sc.nextLine();
				if (compAntigua.equals(a.getCompannia())) {
					System.out.println("Todo correcto,dime tu nueva compañia");
					compNueva=sc.nextLine();
					a.setCompannia(compNueva);
				} else {
					System.out.println("Compañia no encontrada.");
				}
			} else if (opcion2.equals("f")) {
				System.out.println("Avión con id: "+identificador+" de la compañía "+a.getCompannia()+" ha realizado "+a.getNumVuelos()+" vuelos, con un total de "+a.getTotalKm()+" km y una media de "+a.getMediaKm()+" km por vuelo.");
			}
		}while(!(opcion2.equals("g")));
		System.out.println("Fin");
	}

}
