package collections.boletin1.ejercicio7;

import java.util.Scanner;

import collections.boletin1.ejercicio6.model.Diccionario;
import collections.boletin1.ejercicio7.exception.CajaException;
import collections.boletin1.ejercicio7.model.Almacen;
import collections.boletin1.ejercicio7.model.Caja;

public class Main {

	public static void main(String[] args) {
		/* try {
			a.abrirCaja(2);
			//a.abrirCaja(2);
			a.cerrarCaja(2);
			//a.cerrarCaja(4);
		} catch (CajaException e) {
			e.printStackTrace();
		}
		
		System.out.println(a.nuevoCliente());
		System.out.println(a.nuevoCliente());
		
		try {
			a.abrirCaja(20);
			System.out.println(a.atenderCliente(1));
		} catch (CajaException e) {
			e.printStackTrace();
		}
		*/
		
		Scanner sc = new Scanner(System.in);
		String menu="1. Abrir caja.\r\n"
				+ "2. Cerrar caja.\r\n"
				+ "3. Nuevo cliente.\r\n"
				+ "4. Atender cliente.\r\n"
				+ "5. Salir.\r\n";
		int opcion=0,numCaja=0;
		Almacen a = new Almacen();

		do {
			do {
				System.out.println(menu);
				System.out.println("Elije una opcion:");
				opcion = Integer.valueOf(sc.nextLine());
			} while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5);
			
			if(opcion==1) {
				System.out.println("Introduce el número de la caja: ");
				numCaja = Integer.valueOf(sc.nextLine());
				
				try {
					a.abrirCaja(numCaja);
				} catch (CajaException e) {
					e.printStackTrace();
				}
			} else if (opcion==2) {
				System.out.println("Introduce el número de la caja: ");
				numCaja = Integer.valueOf(sc.nextLine());
				
				try {
					a.cerrarCaja(numCaja);
				} catch (CajaException e) {
					e.printStackTrace();
				}
			} else if (opcion==3) {
				System.out.println(a.nuevoCliente());
			
			} else if (opcion==4) {
				System.out.println("Introduce el número de la caja: ");
				numCaja = Integer.valueOf(sc.nextLine());
				try {
					System.out.println(a.atenderCliente(numCaja));
				} catch (CajaException e) {
					e.printStackTrace();
				}
				
			}
			
		} while(opcion!=5);
		System.out.println("Fin del programa.");
	}

}
