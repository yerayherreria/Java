package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio6_YHO {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int dia = 0;
		int mes = 0;
		
		do {
			System.out.println("Escribe el mes: (1-12) ");
			mes = Integer.valueOf(sc.nextLine());
		}while(mes<1 || mes>12);
		
		if (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12) {
			do {
				System.out.println("Escribe el día: (1-31)");
				dia = Integer.valueOf(sc.nextLine());
			}while(dia<1 || dia>31);
		}else if (mes==4 || mes==6 || mes==9 || mes==11) {
			do {
				System.out.println("Escribe el día: (1-30)");
				dia = Integer.valueOf(sc.nextLine());
			}while(dia<1 || dia>30);
		}else {
			do {
				System.out.println("Escribe el día: (1-28)");
				dia = Integer.valueOf(sc.nextLine());
			}while(dia<1 || dia>28);
		}
		if ((dia>=20 && mes==3) || (dia<21 && mes==6) || mes==4 || mes==5) {
			System.out.println("Esta usted en Primavera con 20º.");
		}else if ((dia>=21 && mes==6) || (dia<23 && mes==9) || mes==7 || mes==8) {
			System.out.println("Esta usted en Verano con 24º.");
		}else if ((dia>=23 && mes==9) || (dia<22 && mes==12) || mes==10 || mes==11) {
			System.out.println("Esta usted en Otoño con 19º.");
		}else if ((dia>=22 && mes==12) ||  (dia<20 && mes==3) || mes==1 || mes==2) {
			System.out.println("Esta usted en Invierno con 19º.");
		}
	}
}