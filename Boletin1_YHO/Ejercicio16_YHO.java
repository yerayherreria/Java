package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio16_YHO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cont = 0, suma=0, acum=0;
		do {
			System.out.println("Escribe el salario mensual:");
			int salario = Integer.valueOf(sc.nextLine());
			
			if (salario>0) {
				suma+=salario;
			}
			if (salario>1000) {
				acum+=1;
			}
			cont++;
		}while(cont<10);
		System.out.println("La suma del salario es "+suma+" y hay "+acum+" mayores que 1000€.");
	}

}
