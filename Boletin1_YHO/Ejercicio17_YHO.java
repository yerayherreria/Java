package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio17_YHO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe los términos que deseas que muestre:");
		int secuencia = Integer.valueOf(sc.nextLine());
        int num1 = 0, num2 = 1, suma = 1;
         
        for (int i = 1; i < secuencia+1; i++) {
            System.out.println(suma);
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;
	 
		}
	}
}
