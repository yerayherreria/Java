package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio3_YHO {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Escriba en el caracter:");
		String caracter=String.valueOf(sc.nextLine());
		
		char caracterChar = caracter.charAt(0);
		
		if (caracterChar>=65 && caracterChar<=90) {
			System.out.println("El caracter es una letra mayúcula.");
		}else if (caracterChar>=97 && caracterChar<=122) {
			System.out.println("El caracter es una letra minúscula.");
		}else if (caracterChar>=48 && caracterChar<=57) {
			System.out.println("El caracter es un dígito entre 0 y 9.");
		}else if ((caracterChar>=33 && caracterChar<=47) || (caracterChar>=58 && caracterChar<=63)) {
			System.out.println("El caracter es un signo de puntuación.");
		}else if (caracterChar==32) {
			System.out.println("El caracter es un espacio en blanco.");
		}else if (caracterChar>=40 && caracterChar<=41) {
			System.out.println("El caracter es un paréntesis.");
		}else if (caracterChar==123 || caracterChar==125) {
			System.out.println("El caracter es una llave.");
		}else {
			System.out.println("Otro caracter.");
		}
	}
}
