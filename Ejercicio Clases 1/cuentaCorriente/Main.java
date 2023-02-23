package com.cuentaCorriente;

import java.util.Scanner;

import com.cuentaCorriente.model.Cuenta;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Cuenta c= new Cuenta();
		String menu="1. Hacer un reintegro."
				+ "\n2. Hacer un ingreso."
				+ "\n3. Consultar el saldo y el número de reintegros e ingresos realizados."
				+ "\n4. Finalizar las operaciones.";
	
		double saldo=0;
		int opcion=0;
		do {
			System.out.println("Introduce el saldo: ");
			saldo = Double.valueOf(sc.nextLine());
			c.setSaldo(saldo);
		} while(saldo<0);
		
		do {
			do {
				System.out.println(menu);
				opcion=Integer.valueOf(sc.nextLine());
			} while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4);
			if (opcion==1) {
				System.out.println("¿Que saldo desea retirar?");
				double retirar=Double.valueOf(sc.nextLine());
				c.retirarSaldo(retirar);
			} else if (opcion==2) {
				System.out.println("¿Que saldo desea ingresar?");
				double ingresar=Double.valueOf(sc.nextLine());
				c.ingresarSaldo(ingresar);
			} else if (opcion==3) {
				System.out.println("El saldo es "+c.getSaldo()+" el número de reintegro es "+c.getRetiro()+" y el numero de ingreso es "+c.getIngreso());
			} else if (opcion==4) {
				System.out.println("¿Desea salir? S/N");
				String salir = sc.nextLine();
				if (salir.equalsIgnoreCase("S")) {
					System.out.println("El saldo es "+c.getSaldo());
					opcion=5;
				}
			}
		}while(opcion!=5);
		System.out.println("Programa acabado.");
	}

}
