package collections.boletin1.ejercicio6Listas;

import java.util.Scanner;

import collections.boletin1.ejercicio6.model.Diccionario;

public class Main {

	public static void main(String[] args) {
		/*Diccionario d = new Diccionario();
		
		d.anniadirPalabraSignificado("hola", "saludo");
		d.anniadirPalabraSignificado("adios", "saludo");
		d.anniadirPalabraSignificado("pasar", "verbo");
		d.anniadirPalabraSignificado("kiwi", "frutoa");
		d.anniadirPalabraSignificado("curro", "cc");
		d.anniadirPalabraSignificado("cc", "cc");
		d.anniadirPalabraSignificado("cc", "ww");

		System.out.println(d.buscarPalabra("cc"));
		//d.borrarPalabra("cc");
		System.out.println(d.buscarPalabra("cc"));
		System.out.println(d.listarPalabra("c"));*/
		Scanner sc = new Scanner(System.in);
		String palabra="", significado="", menu="1. Añadir palabra.\r\n"
				+ "2. Buscar palabra en diccionario.\r\n"
				+ "3. Borrar una palabra del diccionario.\r\n"
				+ "4. Listado de palabras que empiecen por “…”.\r\n"
				+ "5. Salir.\r\n";
		int opcion=0;
		Diccionario diccionario = new Diccionario();
		do {
			do {
				System.out.println(menu);
				System.out.println("Elije una opcion:");
				opcion = Integer.valueOf(sc.nextLine());
			} while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5);
			
			if(opcion==1) {
				System.out.println("Introduce la palabra: ");
				palabra = sc.nextLine();
				System.out.println("Introduce el significado: ");
				significado = sc.nextLine();
				diccionario.anniadirPalabraSignificado(palabra, significado);
			} else if (opcion==2) {
				System.out.println("Introduce la palabra: ");
				palabra = sc.nextLine();
				System.out.println(diccionario.buscarPalabra(palabra));
			} else if (opcion==3) {
				System.out.println("Introduce la palabra: ");
				palabra = sc.nextLine();
				diccionario.borrarPalabra(palabra);
			} else if (opcion==4) {
				System.out.println("Introduce la palabra: ");
				palabra = sc.nextLine();
				System.out.println(diccionario.listarPalabra(palabra));
			}
			
		} while(opcion!=5);
		System.out.println("Fin del programa.");
	}

}
