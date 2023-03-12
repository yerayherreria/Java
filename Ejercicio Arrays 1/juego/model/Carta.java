package arrays.juego.model;

import java.util.Arrays;
import java.util.Random;

public class Carta {
	final static String[] nombreCartas = {"oros","espadas","copas","bastos"};
	final static int[] numerosCartas = {1,2,3,4,5,6,7,8,9,10,11,12};
	
	String[] jugador,jugador2;
	Random r= new Random();
	public Carta(int cantidad) {
		this.jugador= new String[cantidad];
		this.jugador2= new String[cantidad];
	}
	public void repartoCartas() {
		for(int i=0;i<jugador.length;i++) {
			jugador[i] = numerosCartas[r.nextInt(numerosCartas.length)] + " de " + nombreCartas[r.nextInt(nombreCartas.length)];
			jugador2[i] = numerosCartas[r.nextInt(numerosCartas.length)] + " de " + nombreCartas[r.nextInt(nombreCartas.length)];
		}
	}
	@Override
	public String toString() {
		return "Cartas jugador1:\n"+ Arrays.toString(jugador) + "\nCartas jugador2:\n" + Arrays.toString(jugador2);
	}

	
}
