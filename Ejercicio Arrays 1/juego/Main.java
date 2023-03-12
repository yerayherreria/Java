package arrays.juego;

import java.util.Scanner;

import arrays.juego.model.Carta;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuántas cartas en reparto?");
 		Carta c2 = new Carta(Integer.valueOf(sc.nextLine()));
 		c2.repartoCartas();
 		System.out.println(c2);
	}

}
