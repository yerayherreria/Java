package Mock_Exam;

import java.util.Scanner;

public class Ejer1_YHO {
	public static final double ENTRADA_GENERAL = 8;
	public static final double ENTRADA_DIA_ESPECTADOR = 5;
	public static final double ENTRADA_DIA_PAREJA = 11;
	public static final double DESCUENTO = 0.1;
	public static final String DIA_SEMANA = "LMXJVSD";
	public static final String TARJETA_DESCUENTO = "SN";
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numEntrada=0;
		String diaSemana="",tarjeta="";
		do {
			int precioFinal=0;
			do {
				System.out.println("Número de entradas:");	
				numEntrada = Integer.valueOf(sc.nextLine());
			}while(numEntrada<0);
			do {
				System.out.println("Día de la semana (L,M,X,J,V,S,D)");
				diaSemana= String.valueOf(sc.nextLine());
				diaSemana=diaSemana.toUpperCase();
			}while(DIA_SEMANA.indexOf(diaSemana)==-1);
			do {
				System.out.println("Tienes tarjeta cineJacaranda? (S/N)");
				tarjeta= String.valueOf(sc.nextLine());
				tarjeta=tarjeta.toUpperCase();
			}while(TARJETA_DESCUENTO.indexOf(tarjeta)==-1);
			
			if (diaSemana=="X") {
				precioFinal+=numEntrada*ENTRADA_DIA_ESPECTADOR;
			} else if (diaSemana=="J") {
				if (numEntrada%2==0) {
					precioFinal+=(numEntrada/2)*ENTRADA_DIA_PAREJA;
				} else {
					precioFinal+=(numEntrada/2)*ENTRADA_DIA_PAREJA+ENTRADA_GENERAL;
				}
			} else {
				precioFinal+=numEntrada*ENTRADA_GENERAL;
			}
			if (tarjeta=="S") {
				precioFinal*=(1-DESCUENTO);
			}
			System.out.println(precioFinal);
		}while(numEntrada>0);
	}
}
