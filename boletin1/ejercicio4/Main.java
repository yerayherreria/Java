package collections.boletin1.ejercicio4;

import java.time.LocalDateTime;
import java.util.Scanner;

import collections.boletin1.ejercicio4.exception.HistorialException;
import collections.boletin1.ejercicio4.model.Historial;
import collections.boletin1.ejercicio4.model.PaginaWeb;

public class Main {

	public static void main(String[] args) {
		/*
		PaginaWeb p1 = new PaginaWeb("https://www.tuxulo.com",LocalDateTime.of(2004,12,2,11,10,30));
		PaginaWeb p2 = new PaginaWeb("https://www.papigavi.com",LocalDateTime.now());
		System.out.println(p1);
		Historial h = new Historial();
		try {
			h.annyadirWeb(p1);
			h.annyadirWeb(p2);
		} catch (HistorialException e) {
			e.printStackTrace();
		}
		System.out.println(h.mostrarHistorial());
		try {
			System.out.println(h.mostrarHistorialPorDia(14));
		} catch (HistorialException e) {
			e.printStackTrace();
		}
		//h.borrarHistorial();
		h.borrarHistorialVista(null);
		System.out.println(h);
		h.borrarHistorialVista("https://www.papigavi.com");
		System.out.println(h);
		*/
		int opcion=0;
		String menu="Bienvenido!\n" 
			+ "1. Nueva página consultada.\n"
			+ "2. Consultar historial completo.\n"
			+ "3. Consultar historial de un día.\n"
			+ "4. Borrar todo el historial.\n"
			+ "5. Borrar visitas a una página.\n"
			+ "6. Salir.";
		Scanner sc = new Scanner(System.in);
		Historial h = new Historial();
		do {
			String url="";
			LocalDateTime fecha;
			int dia=0;
			do {
				System.out.println(menu);
				System.out.println("Escribe la opción: ");
				opcion=Integer.valueOf(sc.nextLine());
			}while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 && opcion!=6);
			
			if(opcion==1) {
				try {
					System.out.println("Escribe la url de la web:");
					url = sc.nextLine();
					fecha = LocalDateTime.now();
					h.annyadirWeb(new PaginaWeb(url,fecha));
				} catch (HistorialException e) {
					e.printStackTrace();
				}
			} else if (opcion==2) {
				System.out.println(h.mostrarHistorial());
			} else if (opcion==3) {
				System.out.println("¿Que día deseas consultar?");
				dia = Integer.valueOf(sc.nextLine());
				try {
					System.out.println(h.mostrarHistorialPorDia(dia));
				} catch (HistorialException e) {
					e.printStackTrace();
				}
			} else if (opcion==4) {
				h.borrarHistorial();
			} else if (opcion==5) {
				System.out.println("Escribe la url del sitio que deses borrar: ");
				url = sc.nextLine();
				h.borrarHistorialVista(url);
				
			}
		}while(opcion!=6);
		System.out.println("Fin del programa.");
	}

}
