package arrays.letras.model;

import java.util.Arrays;

public class Letra {
	final static private String ABECEDARIO = "abcdefghijklmnopqrstuvwxyz" ;

	private int[] contadores = new int[26];
	
	public void vecesRepetidaLetra(String frase) {
		for(int i = 0; i < frase.length(); i++) {
			if(ABECEDARIO.indexOf(frase.charAt(i))!= -1) {
				contadores[Integer.valueOf(String.valueOf(ABECEDARIO.indexOf(frase.charAt(i))))] ++;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<ABECEDARIO.length();i++) {
			if(contadores[i]>0) {
				sb.append("Letra "+ ABECEDARIO.charAt(i) +" aparace " + contadores[i] +" veces.\n");
			}	
		}
		return sb.toString();
	}
	
}
