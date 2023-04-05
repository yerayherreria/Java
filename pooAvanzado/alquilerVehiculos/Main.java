package alquilerVehiculos;

import java.util.Scanner;

import alquilerVehiculos.excepciones.AlquilerException;
import alquilerVehiculos.excepciones.FurgonetaException;
import alquilerVehiculos.excepciones.MicronbusException;
import alquilerVehiculos.model.Alquiler;
import alquilerVehiculos.model.Coche;
import alquilerVehiculos.model.Combustible;
import alquilerVehiculos.model.Furgoneta;
import alquilerVehiculos.model.Gama;
import alquilerVehiculos.model.Microbus;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		String menu="1. Alta de vehículo\r\n" + "2. Cálculo de precio de alquiler\r\n" + "3. Salir.";	
		int opcion=0;
		
		do {
			do {
				System.out.println(menu);
				System.out.println("Seleccion la opción: ");
				opcion = Integer.valueOf(sc.nextLine());
			} while(opcion!=1 && opcion!=2 && opcion!=3);
			
			Alquiler a = new Alquiler();
			
			if (opcion==1) {
				System.out.println("Introduce la matricula: ");
				String matricula = sc.nextLine();
				
				Gama gama = null;
				do {
					try {
						System.out.println("Introduce el tipo gama: ");
						gama = Gama.valueOf(sc.nextLine().toUpperCase());
					}catch(Exception e) {
						System.out.println("Error.");
					}
				}while(gama == null);
				
				System.out.println("Introduce el tipo de vehiculo: ");
				String tipoVehiculo = sc.nextLine().toUpperCase();
				
				if(tipoVehiculo.equals("COCHE")) {
					Combustible combustible=null;
					do {
						try {
							System.out.println("Introduce el combustible: ");
							combustible = Combustible.valueOf(sc.nextLine().toUpperCase());
						}catch(Exception e) {
							System.out.println("Error.");
						}
					}while(combustible==null);
					
					try {
						a.altaVehiculo(new Coche(matricula,gama,combustible));
					} catch (AlquilerException e) {
						e.printStackTrace();
					}
					
				}else if(tipoVehiculo.equals("MICROBUS")) {
					System.out.println("Introduce el número de plazas: ");
					int plaza = Integer.valueOf(sc.nextLine());
					try {
						a.altaVehiculo(new Microbus(matricula,gama,plaza));
					} catch (AlquilerException e) {
						e.printStackTrace();
					} catch (MicronbusException e) {
						e.printStackTrace();
					}
					
				}else if(tipoVehiculo.equals("FURGONETA")) {
					System.out.println("Introduce la carga maxima autorizada: ");
					double pma = Double.valueOf(sc.nextLine());
					try {
						a.altaVehiculo(new Furgoneta(matricula,gama,pma));
					} catch (AlquilerException e) {
						e.printStackTrace();
					} catch (FurgonetaException e) {
						e.printStackTrace();
					}
				}
				
			} else if (opcion==2) {
				System.out.println("Introduce la matricula: ");
				String matricula=sc.nextLine();
				System.out.println("Introduce la cantidad de días de alquiler: ");
				int dias=Integer.valueOf(sc.nextLine());
		
				System.out.println(a.calcularPrecioAlquiler(matricula, dias));
			}
		} while(opcion!=3);
		
		System.out.println("Programa finalizado.");
	}

}
