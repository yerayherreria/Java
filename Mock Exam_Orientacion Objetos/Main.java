package mockExam.orientacioObjetos;

import java.util.Scanner;

import mockExam.orientacioObjetos.model.Plato;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Plato[] menu = new Plato[10];
		int cont = 0;
		int opcion=0;
		String menu1="1. Dar de alta plato\n"
				+ "2. Modificar precio al plato\n"
				+ "3. Asignar vino al plato\n"
				+ "4. Mostar informacion de un plato\n"
				+ "5. Mostar informacion de todos los platos\n"
				+ "6. Salir";
		while(opcion!=6) {
			System.out.println(menu1);
			opcion = Integer.valueOf(sc.nextLine());
			
			if (opcion == 1) {
				System.out.println("Introduzca el nombre del plato: ");
				String nombrePlato = sc.nextLine();
				System.out.println("Introduzca el precio del plato: ");
				double precioPlato = Double.valueOf(sc.nextLine());
				
				if(buscarPlato(nombrePlato, menu)!=-1) {
					System.out.println("El plato no se puede crear porque ya existe");
				}else {
					menu[cont%(menu.length)]= new Plato(nombrePlato, precioPlato);
					cont++;
				}
				
			}else if(opcion == 2) {
				int posicion = -1;
				do {
					System.out.println("Introduzca el nombre del plato: ");
					String nombrePlato = sc.nextLine();
					posicion= buscarPlato(nombrePlato, menu);
				}while(posicion==-1 && menu[0]!=null);
	
				System.out.println("Introduzca el precio del plato: ");
				double precioPlato = Double.valueOf(sc.nextLine());

				menu[posicion].setPrecio(precioPlato);

			}else if(opcion == 3) {
				int posicion = -1;
				do {
					System.out.println("Introduzca el nombre del plato: ");
					String nombrePlato = sc.nextLine();
					posicion= buscarPlato(nombrePlato, menu);
				}while(posicion==-1 && menu[0]!=null);
				
				System.out.println("Introduzca el nombre del vino: ");
				String vino = sc.nextLine();
				System.out.println("Introduzca la graduación: ");
				double graduacion = Double.valueOf(sc.nextLine());
				menu[posicion].setVinoRecomendado(vino,graduacion);
				
			}else if(opcion ==4) {
				int posicion = -1;
				do {
					System.out.println("Introduzca el nombre del plato: ");
					String nombrePlato = sc.nextLine();
					posicion= buscarPlato(nombrePlato, menu);
				}while(posicion==-1 && menu[0]!=null);
				
				System.out.println(menu[posicion]);
				
			}else if(opcion == 5) {
				for(Plato p : menu) {
					if(p!=null) {
						System.out.println(p);
					}
				}
			}
		}
	}

	public static int buscarPlato(String nombre, Plato[] menu) {
		int posicion = -1;
		for(int i =0; i< menu.length && posicion==-1; i++) {
			if(menu[i]!=null && menu[i].getNombre().equalsIgnoreCase(nombre)) {
				posicion=i;
			}
			
		}
		return posicion;
	}
}
