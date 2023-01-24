package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio1_YHO {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean multiplo = false;
		System.out.println("Introduce un numero:");
		int num1=Integer.valueOf(sc.nextLine());
		System.out.println("Introduce otro numero:");
		int num2=Integer.valueOf(sc.nextLine());
		
		if ((num1%num2==0) || (num2%num1==0)) {
			multiplo = true;
		}

		System.out.println(multiplo);

	}

}
