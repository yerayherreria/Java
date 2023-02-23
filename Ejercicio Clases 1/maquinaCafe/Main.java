package com.maquinaCafe;

import java.util.Scanner;

import com.maquinaCafe.model.Maquina;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Maquina m= new Maquina();
		String menu="1. Servir café solo (1 euro)\n"
				+ "2. Servir leche (0,8 euros)\n"
				+ "3. Servir café con leche (1,5 euros)\n"
				+ "4. Consultar estado máquina. Aparecen los datos de los depósitos y del\n"
				+ "monedero\n"
				+ "5. Apagar máquina y salir";
		int monedero=0,opcion=0;
		do {
			System.out.println("Cuanto dinero va a tener la máquina:");
			monedero=Integer.valueOf(sc.nextLine());
		} while (monedero<0);
		m.setMonederoMaquina(monedero);
		m.llenarDepositos();
		do {
			do {
				System.out.println(menu);
				System.out.println("Introduce una opcion:");
				opcion=Integer.valueOf(sc.nextLine());
			} while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5);
			
			if (opcion==1) {
				System.out.println("Introduce el dinero:");
				double dinero=Double.valueOf(sc.nextLine());
				System.out.println(m.servirCafe(dinero));
			} else if (opcion==2) {
				System.out.println("Introduce el dinero:");
				double dinero=Double.valueOf(sc.nextLine());
				System.out.println(m.servirLeche(dinero));
			} else if (opcion==3) {
				System.out.println("Introduce el dinero:");
				double dinero=Double.valueOf(sc.nextLine());
				System.out.println(m.servirCafeLeche(dinero));
			} else if (opcion==4) {
				System.out.println(m.consultarEstado());
			} 
		}while (opcion!=5);
		
		System.out.println("Programa acabado.");
	}

}
