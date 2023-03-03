package com.liga;

import java.util.Scanner;

import com.liga.model.Equipo;
import com.liga.model.Partido;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Equipo local = new Equipo();
		Equipo visitante = new Equipo();
		int jornada=0;
		do {
		System.out.println("Introduce el nombre del equipo local:");
		local = new Equipo(sc.nextLine());
		System.out.println("Introduce el nombre del equipo visitante:");
		visitante = new Equipo(sc.nextLine());
		} while(local.getNombreEquipo().equals(visitante.getNombreEquipo()));

		do {
			System.out.println("Introduce la jornada (1-38)");
			jornada = Integer.valueOf(sc.nextLine());
		} while(jornada < 1 || jornada > 38);
		
		Partido p = new Partido(local,visitante,jornada);
		
		System.out.println("Introduce el resultado:");
		p.ponerResultado(sc.nextLine());
		
		p.asignarQuiniela();
		System.out.println(p);
	}

}
