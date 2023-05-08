package ficheros.feria;

import java.io.IOException;
import java.util.Scanner;

import ficheros.feria.model.Feria;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu="1. Mostrar todas las casetas existentes en una calle.\r\n"
				+ "2. Mostrar todas las casetas de tipo familiar.\r\n"
				+ "3. Mostrar todas las casetas de tipo Distrito\r\n"
				+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos.\r\n"
				+ "5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar\r\n"
				+ "que existen.\r\n"
				+ "6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito\r\n"
				+ "que existen.\r\n"
				+ "7. Eliminar una caseta.\r\n"
				+ "8. Salir.";
		int opcion= 0;
		String calle="",num="";
		Feria f = new Feria("./ficheros/casetasferia.xml");
		
		try {
			f.cargarJson();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		do {
			do {
				System.out.println(menu);
				opcion = Integer.valueOf(sc.nextLine());
			} while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 && opcion!=6 && opcion!=7 && opcion!=8);
			if(opcion==1) {
				System.out.println("Introduce la calle:");
				calle = sc.nextLine();
				System.out.println(f.obtenerCasetaPorCalle(calle.toUpperCase()));
			} else if (opcion==2) {
				System.out.println(f.obtenerCasetaFamiliar());
			} else if (opcion==3) {
				System.out.println(f.obtenerCasetaDistrito());
			} else if (opcion==4) {
				System.out.println(f.obtenerCasetaNiDistritoNiFamiliares());
			} else if (opcion==5) {
				System.out.println(f.obtenerCasetaPorCalleFamiliar());
			} else if (opcion==6) {
				System.out.println(f.obtenerCasetaPorCalleDistrito());
			} else if (opcion==7) {
				System.out.println("Introduce la calle:");
				calle = sc.nextLine();
				System.out.println("Introduce el numero de caseta:");
				num = sc.nextLine();
				try {
					f.eliminarCaseta(calle.toUpperCase(), num);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		}while(opcion!=8);
		System.out.println("Programa finalizado.");
	}

}
