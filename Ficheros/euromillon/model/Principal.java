package ficheros.euromillon.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		/*
		try {
			Combinacion comb1 = new Combinacion(1,2,3,4,5,1,2);
			Combinacion comb2 = new Combinacion(1,2,3,4,5,1,2);
			
			Historial historial = new Historial();
			
			historial.addSorteo(LocalDate.now().minusDays(30), comb1);
			historial.addSorteo(LocalDate.now().minusDays(10), comb2);
			historial.addSorteo(LocalDate.now().minusDays(11), new Combinacion(6,7,8,9,10, 1,3));
			historial.addSorteo(LocalDate.now().minusDays(12), new Combinacion(6,5,8,9,10, 5,3));
			historial.addSorteo(LocalDate.now().minusDays(13), new Combinacion(6,5,8,9,10, 5,3));

			System.out.println(historial.mostrarHistorico());
			System.out.println(historial.listarSorteosDesdeFecha(LocalDate.of(2023,4,21)));
		}catch(CombinacionException | HistorialException c) {
			System.out.println(c.getMessage());
		}
		
		System.out.println(new Random().nextInt(1, 30));
		System.out.println(new Random().nextInt(1, 30));
		System.out.println(new Random().nextInt(1, 30));*/
		
		File fichero1 = new File("C:\\Users\\Yeray\\Desktop\\Carpetitas\\ficheropro\\Euromillones 2004 a 2023.csv");
		BufferedReader buffer;
		
		try {
			buffer = new BufferedReader(new FileReader(fichero1));
			String linea = buffer.readLine();
			linea = buffer.readLine();
			Historial h =new Historial();
			
			while(linea!=null) {
				try {
					h.addSorteo(linea);
				} catch (CombinacionException e) {
					e.printStackTrace();
				}
				
				//System.out.println(h);
				
				linea = buffer.readLine();

			}
			buffer.close();
			System.out.println(h.numMin());
			System.out.println(h.numMax());
			System.out.println(h.estreMax());
			System.out.println(h.estreMin());
			System.out.println(h.maxAcierto(new Combinacion(12,13,14,15,5,12,1)));
			System.out.println(h.numSecuenciaCombinacion());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CombinacionException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
/*
	private static void probarConstructor() {
		try {
			Combinacion comb1 = new Combinacion(1,2,2,4,5,1,2);
		}catch(CombinacionException c) {
			System.out.println(c.getMessage());
		}
		try {
			Combinacion comb1 = new Combinacion(1,2,3,4,5,1,1);
		}catch(CombinacionException c) {
			System.out.println(c.getMessage());
		}
		try {
			Combinacion comb1 = new Combinacion(1,2,3,4,5,1,2);
		}catch(CombinacionException c) {
			System.out.println(c.getMessage());
		}
		try {
			Combinacion comb1 = new Combinacion(1,2,51,4,5,1,2);
		}catch(CombinacionException c) {
			System.out.println(c.getMessage());
		}
		try {
			Combinacion comb1 = new Combinacion(1,2,3,4,5,1,14);
		}catch(CombinacionException c) {
			System.out.println(c.getMessage());
		}
		try {
			Combinacion comb1 = new Combinacion(-1,2,3,4,5,1,12);
		}catch(CombinacionException c) {
			System.out.println(c.getMessage());
		}
		
	}*/
	
	
}
