package Boletin1_YHO;

import java.util.Scanner;

public class Ejercicio18_YHO {
	public static double calcularAreaCirculo(double radio) {
		double area = Math.PI * Math.pow(radio,2);
		return area;
	}
	public static double calcularLongitudCirculo(double radio) {
		double longitud = (2*Math.PI) * radio;
		return longitud;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el radio:");
		double radio = Integer.valueOf(sc.nextLine());
		
		System.out.println("El area es "+ calcularAreaCirculo(radio));
		System.out.println("La longitud es " + calcularLongitudCirculo(radio));
	}
}
