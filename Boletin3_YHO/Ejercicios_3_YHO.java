package Boletin3_YHO;

import java.util.Scanner;

public class Ejercicios_3_YHO {
	Scanner sc = new Scanner(System.in);
	//Ejercicio 1
	//for
	public static String imprimirPosicionParImparFor(String frase,boolean esPar) {
		String resultado="";
		for (int i=0;i<=frase.length()-1;i++) {
			if ((i%2!=0) && (!esPar)) {
				resultado+=frase.charAt(i);
			} else if ((i%2==0) && (esPar)) {
				resultado+=frase.charAt(i);
			}
		}
		return resultado;
	}
	//while 
	public static String imprimirPosicionParImparWhile(String frase,boolean esPar) {
		String resultado="";
		int cont=0;
		
		while (cont<=frase.length()-1) {
			if ((cont%2!=0) && (!esPar)) {
				resultado+=frase.charAt(cont);
			} else if ((cont%2==0) && (esPar)) {
				resultado+=frase.charAt(cont);
			}
			cont++;
		}
		return resultado;
	}
	//do-while
	public static String imprimirPosicionParImparDoWhile(String frase,boolean esPar) {
		String resultado="";
		int cont=0;
		do {
			if ((cont%2!=0) && (!esPar)) {
				resultado+=frase.charAt(cont);
			} else if ((cont%2==0) && (esPar)) {
				resultado+=frase.charAt(cont);
			}
			cont++;
		}while (cont<=frase.length()-1);
		return resultado;
	}
	//Ejercicio 2
	public static boolean esDivisible(int num) {
		boolean esDivisible=false;
		int sumaCifra=0;
		String numStr = String.valueOf(num);
		for (int i=0;i<=numStr.length()-1;i++) {
			sumaCifra+=Integer.valueOf(numStr.substring(i, i+1));
		} if (sumaCifra%3==0) {
			esDivisible=true;
		} return esDivisible;
	}
	//Ejercicio 3
	public static int contarPalabras(String frase,String palabra) {
		int numVeces=0,cont=0;
		for (int i=0;i<=frase.length()-1;i++) {
			if (frase.charAt(i)==palabra.charAt(cont)) {
				cont++;
			} else {
				cont=0;
			} if (cont==palabra.length()) {
				numVeces++;
				cont=0;
			}
		}
		return numVeces;
	}
	//Ejercicio 4
	public static boolean contains(String frase,String palabra) {
		int cont=0;
		boolean palabraEncontrada=false;
		for (int i=0;i<=frase.length()-1;i++) {
			if (frase.charAt(i)==palabra.charAt(cont)) {
				cont++;
			} else {
				cont=0;
			} if (cont==palabra.length()) {
				palabraEncontrada=true;
				cont=0;
			}
		}
		return palabraEncontrada;
	}
	public static boolean startsWirth(String frase,String palabra) {
		boolean empiezaPalabra=false;
		if (frase.substring(0,palabra.length()).equals(palabra)) {
			empiezaPalabra=true;
		}
		return empiezaPalabra;
	}
	public static boolean endsWith(String frase,String palabra) {
		boolean acabaPalabra=false;
		if (frase.substring(frase.indexOf(palabra.charAt(0)), frase.length()).equals(palabra)) {
			acabaPalabra=true;
		}
		return acabaPalabra;
	}
	//Ejercicio 5
	public static boolean esPalindromo(String frase) {
		String palabraAlReves = "",fraseSinEspacio="";
		boolean resultado=false;
		frase=frase.toLowerCase();
		for (int i=0;i<frase.length()-1;i++) {
			if(!Character.isWhitespace(frase.charAt(i))) {
				fraseSinEspacio+=frase.charAt(i);
			}
		}
		for (int i=frase.length()-1;i>0;i--) {
			if(!Character.isWhitespace(frase.charAt(i))) {
				palabraAlReves+=frase.charAt(i);
			}
		}
		if (palabraAlReves.equals(fraseSinEspacio)) {
			resultado=true;
		}
		return resultado;
	}
	//Ejercicio 6
	public static boolean esCapicua(double num) {
		String numAlReves="",numCadena = String.valueOf(num),numSinPunto="";
		boolean resultado=false;
		for (int i=0;i<numCadena.length()-1;i++) {
			if (numCadena.charAt(i) != '.') {
				numSinPunto+=numCadena.charAt(i);
			}	
		}for (int i=numCadena.length()-1;i>0;i--) {
			if (numCadena.charAt(i) != '.') {
				numAlReves+=numCadena.charAt(i);
			}	
		}if (numSinPunto.equals(numAlReves)){
			resultado=true;
		}return resultado;
	}
	//Ejercicio 7
	public static boolean esPalabraEscondida(String frase,String palabra) {
		boolean resultado=false;
		int cont=0;
		for(int i=0;i<frase.length();i++) {
			if((cont<palabra.length()) && (palabra.charAt(cont))==frase.charAt(i)) {
				cont ++;
			}
		}if(cont == palabra.length()) {
			resultado = true;
		}
		return resultado;
	}
	//Ejercicio 8
	public static String sustituirPalabra(String frase,String palabra,String sustituta) {
		int cont=0;
		StringBuilder resultado=new StringBuilder();
		String acum="";
			
		for (int i=0;i<frase.length();i++) {
			if (frase.charAt(i)==palabra.charAt(cont)) {
				acum+=palabra.charAt(cont);
				cont++;
				if (palabra.length()==cont) {
					resultado.append(sustituta);
					acum="";
					cont=0;
				}
			} else {
				resultado.append(acum + frase.charAt(i));
				cont=0;
			}
		}
		return resultado.toString();
	}
	//Ejercicio 9
	public static String contarPalabrasFrasesParrafos(String texto) {
		int palabra=0,frase=0,parrafo=0;
		if(texto.length() > 0) { 
			parrafo ++;
			for (int i=0;i<texto.length();i++) {
				if (i==0 && !texto.substring(i, i+1).equals(" ")) {
					palabra++;
				} else if (!texto.substring(i,i+1).isBlank() &&  texto.substring(i-1, i).isBlank()) {
					palabra++;
				} else if (texto.substring(i,i+1).isBlank() &&  texto.substring(i-1, i).equals(".")) {
					frase++;
				} else if (texto.substring(i,i+1).equals("\n")) {
					parrafo++;
				}
			}
		}
		return ("Hay "+parrafo+" parrafos, "+frase+" frase y "+palabra+" palabras.");
	}
	//Ejercicio 10
	public static final String ABECEDARIO = "abcdhfghijklmnopqrstuvwxyz";
	public static char cifradoCesarCaracter(char caracter,int desplazamiento) {
		//Lo he realizado para que nos devuelva String pero si pongo z sale de rango por eso el modular.
		/*String resultado="";
		for (int i=0;i<ABECEDARIO.length();i++) {
			if (caracter==ABECEDARIO.charAt(i)) {
				resultado+=ABECEDARIO.charAt(i+desplazamiento);
			}
		}
		return resultado;*/
		return ABECEDARIO.charAt((ABECEDARIO.indexOf(caracter)+desplazamiento) % ABECEDARIO.length());
	}
	public static String cifradoCesarCadena(String palabra,int desplazamiento) {
		StringBuilder sb = new StringBuilder();
		int cont=0;
		palabra= palabra.toLowerCase();
		while (cont<palabra.length()) {
			sb.append(cifradoCesarCaracter(palabra.charAt(cont),desplazamiento));
			cont++;
		}
		return sb.toString();
	}
	public static int obtenerNivelCifrado(String palabra1,String palabra2) {
		int desplazamiento = -1;
		boolean equivalentes = false;
		
		while(!equivalentes && desplazamiento < ABECEDARIO.length()) {
			desplazamiento ++;
			equivalentes = palabra2.equalsIgnoreCase(cifradoCesarCadena(palabra1,desplazamiento));
			
		}
			
		return equivalentes?desplazamiento:-1;
	}
	
	public static void main(String[] args) {
		System.out.println(obtenerNivelCifrado("CASADO","FDVDGR"));
	}
}

