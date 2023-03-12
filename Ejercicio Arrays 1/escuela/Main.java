package arrays.escuela;

import java.util.Scanner;

import arrays.escuela.model.Aula;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cont=1,opcion=0;
		String menu="1. Mostrar el nombre y la nota de los alumnos aprobados.\r\n"
				+ "2. Mostrar el nombre y la nota los alumnos suspensos.\r\n"
				+ "3. Mostrar la nota media de la clase.\r\n"
				+ "4. Mostrar los alumnos que tienen más de una nota X (se solicitará\r\n"
				+ "X por teclado).\r\n"
				+ "5. Mostrar el alumno con la nota máxima y mínima.\r\n"
				+ "6. Mostrar un listado ordenado de forma creciente por la nota.\r\n"
				+ "7. Salir.";
		
 		System.out.println("Introduzca el número de alumnos:");
 		int alumnos = Integer.valueOf(sc.nextLine());
 		Aula n = new Aula(alumnos);
 
 		for(int i = 0; i < alumnos; i++) {
 			System.out.println(cont+". Introduzca el nombre del alumno:");
 			String nombre=sc.nextLine();
 			System.out.println(cont+". Introduzca la nota del alumno:");
 			double nota=Double.valueOf(sc.nextLine());
 	 		n.añadirAlumnoNota(nombre, nota);
 	 		cont++;
 		}
 		
 		
 		do {
 			do {
 				System.out.println(menu);
		 		System.out.println("Introduce una opcion: ");
		 		opcion = Integer.valueOf(sc.nextLine());
 			}while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 && opcion!=6 && opcion!=7);
 		
	 		if(opcion == 1) {
	 			System.out.println(n.getAlumnosAprobados());
	 		}else if(opcion == 2) {
	 			System.out.println(n.getAlumnosSuspensos());
	 		}else if(opcion == 3) {
	 			System.out.println(n.getNotaMedia());
	 		}else if(opcion == 4) {
	 			System.out.println("Nota para el corte:");
	 			double nota=Double.valueOf(sc.nextLine());
	 			System.out.println(n.getCorteX(nota));
	 		}else if(opcion == 5) {
	 			System.out.println(n.getMayorMenorNota());
	 		}else if(opcion == 6) {
	 			System.out.println(n.getListadoCrecienteNota());
	 		}
 		}while(opcion!=7);
 		System.out.println("Fin del programa.");
	}
	

}
