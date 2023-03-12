package arrays.letras;

import java.util.Scanner;

import arrays.letras.model.Letra;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Letra l = new Letra();
 		l.vecesRepetidaLetra("holalalalalal al mdaom peop hola que pasa");
 		System.out.println(l);
	}

}
