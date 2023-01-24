package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio14_YHO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cont=0;
		int num=0;
		int impar=0;
		int mayorPar=num;
		int contImpar=0;
		while(cont<10) {
			System.out.println("Escribe un número: ");
			num = Integer.valueOf(sc.nextLine());	
			cont++;
			if ((num%2==0) && (num>mayorPar)) {
				mayorPar=num;
			}else {
				contImpar++;
				impar+=num;
			}
		}		
		int mediaImpar=impar/contImpar;
		System.out.println("Usted ha introducido "+ cont);
		System.out.println("El mayor par es "+ mayorPar);
		System.out.println("La media de impares es "+ mediaImpar);
	}

}
