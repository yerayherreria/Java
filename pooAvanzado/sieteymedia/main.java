package pooavanzado.sieteymedia;

import java.util.Scanner;

import pooavanzado.sieteymedia.model.Baraja;
import pooavanzado.sieteymedia.model.Carta;
import pooavanzado.sieteymedia.model.Palo;

public class main {
	public static final double SIETEYMEDIA=7.5;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Carta carta;
		try {
			carta=new Carta(Palo.COPA,5);
			System.out.println(carta);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Baraja b = new Baraja();
		b.barajar();
		double jugador=0.0,banca=0.0;
		String opcion="";
		
		do {
			do {
				System.out.println("Hola jugador,¿quieres carta?");
				opcion=sc.nextLine().toLowerCase();					
			}while(!(opcion.equals("s") || opcion.equals("n")));
			
			if (jugador>SIETEYMEDIA) {
				opcion="n";
				System.out.println("Te has pasado");
			} if (opcion.equals("s")) {
				Carta c = b.siguienteCarta();
				System.out.println(c);
				jugador+=c.getValor();
			}
		}while(opcion.equals("s"));
		
		do {
			do {
				System.out.println("Hola banca,¿quieres carta?");
				opcion=sc.nextLine().toLowerCase();					
			}while(!(opcion.equals("s") || opcion.equals("n")));
			
			if (banca>SIETEYMEDIA) {
				opcion="n";
				System.out.println("Te has pasado");
			} if (opcion.equals("s")) {
				Carta c = b.siguienteCarta();
				System.out.println(c);
				banca+=c.getValor();
			}
		}while(opcion.equals("s"));
		if ((banca>SIETEYMEDIA && jugador<=SIETEYMEDIA) || (banca<=SIETEYMEDIA && jugador<=SIETEYMEDIA && jugador>banca)) {
			System.out.println("Gana el jugador");
		} else {
			System.out.println("Gana la banca");
		}
	}
}
