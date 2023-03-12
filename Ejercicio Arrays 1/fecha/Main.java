package arrays.fecha;

import java.util.Scanner;

import arrays.fecha.model.Fecha;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el día de la fecha:");
		int dia = Integer.valueOf(sc.nextLine());
		System.out.println("Introduce el mes de la fecha:");
		int mes = Integer.valueOf(sc.nextLine());
		System.out.println("Introduce el año de la fecha:");
		int anyo = Integer.valueOf(sc.nextLine());
		
		Fecha f = new Fecha(dia,mes,anyo);
		System.out.println(f);
	}

}
