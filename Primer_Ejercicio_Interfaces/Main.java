package enumerados.genero;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import enumerados.genero.model.Genero;
import enumerados.genero.model.Persona;
import enumerados.genero.model.ArraysUtils;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Genero generoIntroducido = null;
		
		do {
			try {
				System.out.println("Introduce genero:");
				String genero = new Scanner(System.in).nextLine();
				generoIntroducido = Genero.valueOf(genero.toUpperCase());
			}catch (Exception e) {
				System.out.println("Genero HOMBRE/MUJER");
			}
		} while (generoIntroducido == null);
		LocalDate fechaNacimiento = null;
		do {
			try {
				System.out.println("Introduce el  año:");
				int annyo = Integer.valueOf(sc.nextLine());
				System.out.println("Introduce el  mes:");
				int mes = Integer.valueOf(sc.nextLine());
				System.out.println("Introduce el  dia:");
				int dia = Integer.valueOf(sc.nextLine());	
				fechaNacimiento = LocalDate.of(annyo, mes, dia);
			} catch (Exception e) {
				System.out.println("Datos incorrectos.");
			}
		} while (fechaNacimiento == null);
		
		Persona p = new Persona ("Curro","Currero",generoIntroducido,fechaNacimiento);
		Persona[] grupo = new Persona[3];
		grupo[0]=p;
		grupo[1]=new Persona ("Pepa","Pepin",Genero.MUJER,fechaNacimiento.minusYears(2));
		grupo[2]=new Persona ("Currito","Ferrero",Genero.HOMBRE,fechaNacimiento.minusYears(5));
		
		p.agacharse();
		System.out.println(Arrays.toString(grupo));
		Arrays.sort(grupo);
		System.out.println("--------");
		System.out.println(Arrays.toString(grupo));
		
	}	
}
