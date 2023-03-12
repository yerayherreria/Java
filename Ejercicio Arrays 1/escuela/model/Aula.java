package arrays.escuela.model;

import java.util.Arrays;

public class Aula {
	private static String[] nombres;
	private static double[] notas;
	
	public Aula(int cantidadDeAlumnos) {
		this.nombres = new String[cantidadDeAlumnos];
		this.notas = new double[cantidadDeAlumnos];
	}
	
	public void añadirAlumnoNota(String nombre, double nota) {
		int cont=0;
		if(cont < nombres.length) {
			nombres[cont] = nombre;
			notas[cont] = nota;
			cont ++;
		}
	}
	
	public static String getAlumnosAprobados() {
		int cont = 0;
		for(int i = 0; i < notas.length;i++) {
			if(notas[i]>=5) {
				cont++;
			}
		}
		String[] aprobados=new String[cont];
		for(int i = 0; i < notas.length;i++) {
			if(notas[i] >= 5.0 && cont > 0) {
				aprobados[cont-1] = nombres[i] +":"+ notas[i];
				cont --;
			}
		} 
		return Arrays.toString(aprobados);
	}
	
	public static String getAlumnosSuspensos() {
		int cont = 0;
		for(int i = 0; i < notas.length;i++) {
			if(notas[i]<5) {
				cont++;
			}
		}
		String[] suspensos=new String[cont];
		for(int i = 0; i < notas.length;i++) {
			if(notas[i] < 5.0 && cont > 0) {
				suspensos[cont-1] = nombres[i] +":"+ notas[i];
				cont --;
			}
		} 	
		return Arrays.toString(suspensos);
	}
	
	public static double getNotaMedia() {
		double acum=0.0;
		for(int i = 0; i < notas.length;i++) {
			acum+=notas[i];
		}
		return acum/notas.length;
	}
	
	public static String getMayorMenorNota() {
		double notaMayor=0.0,menor=0.0;
		int posicionMayor=0,posicionMenor=0;
	
		for(int i = 0; i < notas.length; i++) {
			if(notaMayor > notas[i]) {
				menor = notas[i];
				posicionMenor = i;
			}
		}
		for(int i = 0; i < notas.length; i++) {
			if(notaMayor < notas[i]) {
				notaMayor = notas[i];
				posicionMayor = i;
			}
		}
		
		return "La nota mayor es "+ nombres[posicionMayor] +":"+ notas[posicionMayor] +" y la nota menor es "+ nombres[posicionMenor] +":"+ notas[posicionMenor];
	}
	
	public static String getCorteX(double nota) {
		int cont = 0;
		for(int i=0; i<notas.length; i++) {
			if(notas[i]> nota) {
				cont++;
			}
		}
		String[] NotaX=new String[cont];
		for(int i = 0; i < notas.length;i++) {
			if(notas[i] > nota && cont > 0) {
				NotaX[cont-1] = nombres[i] +":"+ notas[i];
				cont--;
			}
		} 	
		return Arrays.toString(NotaX);
	}
	public static String getListadoCrecienteNota() {
		Arrays.sort(notas);
		return Arrays.toString(notas);
				
	}
	@Override
	public String toString() {
		return Arrays.toString(nombres)+ ":" + Arrays.toString(notas);
	}
}
