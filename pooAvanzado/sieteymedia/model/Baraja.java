package pooavanzado.sieteymedia.model;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Baraja {
	private Carta[] cartas;
	private int siguiente;
	private final static int MAX_SIZE = 40;
	public Baraja() {
		this.cartas=new Carta[MAX_SIZE];
		this.siguiente = 0;
		
		int posicion=0;
		for (Palo p: Palo.values()) {
			for (int i=1; i < 13; i++) {
				if(i!=8 && i!=9) {
					try {
						this.cartas[posicion++]=new Carta(p,i);
					} catch (Exception e) {
						e.printStackTrace();
					}		
				}
			}
		}
	}
   public void barajar() {
	   int posicion = 0;
       Carta c;

       for (int i = 0; i < cartas.length; i++) {
           posicion = generarNumero();
           c = cartas[i];
           cartas[i] = cartas[posicion];
           cartas[posicion] = c;
       }
   }
   public int generarNumero() {
	   return ThreadLocalRandom.current().nextInt(0,MAX_SIZE);
   }
   public Carta siguienteCarta() {
       return this.cartas[siguiente++];
   }
   @Override
	public String toString() {
		return Arrays.toString(cartas);
	}
}
