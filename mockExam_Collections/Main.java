package collections.mockExam_Collections;

import java.time.LocalDate;

import collections.boletin1.ejercicio4.exception.HistorialException;
import collections.mockExam_Collections.exception.CombinacionException;
import collections.mockExam_Collections.model.Combinacion;
import collections.mockExam_Collections.model.Historial;

public class Main {

	public static void main(String[] args) {
		Historial h1 = new Historial();
		Combinacion c1;
		Combinacion c2;
		Combinacion c3;
		try {
			c1 = new Combinacion(1,2,3,4,5,6,7);
			c2 = new Combinacion(11,12,14,15,17,11,12);
			c3 = new Combinacion(11,12,14,15,17,11,12);
			try {
				System.out.println(h1.addSorteo(2, 3, 2022, c1));
				System.out.println(h1.addSorteo(4, 3, 2022, c2));
				//System.out.println(h1.addSorteo(4, 3, 2022, c2));
				System.out.println(h1.actualizarSorteo(3, 4, 2022, c3));
				System.out.println(h1.actualizarSorteo(4, 3, 2022, c3));
				
				System.out.println(h1.listarSorteoDesdeFecha(LocalDate.of(2022, 3, 2)));
				System.out.println(h1.comprobarAciertos(LocalDate.of(2022, 3, 2), c1));
			} catch (HistorialException e) {
				e.printStackTrace();
			}
		} catch (CombinacionException e1) {
			e1.printStackTrace();
		}
		
		
		
	
	}

}
