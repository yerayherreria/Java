package pooavanzado.parking;

import java.time.LocalDate;

import pooavanzado.parking.model.Combustible;
import pooavanzado.parking.model.Parking;
import pooavanzado.parking.model.TipoDeVehiculo;
import pooavanzado.parking.model.Vehiculo;

public class Main {
	public static void main(String[] args) {
		Vehiculo v1= new Vehiculo("Audi","A4","DFGH1234",Combustible.GASOLINA,LocalDate.of(2018,9,2),TipoDeVehiculo.AUTOMOVIL);
		Vehiculo v2= new Vehiculo("Mercedes","A4","DFGH2234",Combustible.GASOLINA,LocalDate.of(2018,9,3),TipoDeVehiculo.AUTOMOVIL);
		Vehiculo v3= new Vehiculo("Peugeut","A4","DFGH3434",Combustible.GASOLINA,LocalDate.of(2018,9,1),TipoDeVehiculo.AUTOMOVIL);
		Vehiculo v4= new Vehiculo("Mclaren","A4","DFGH4434",Combustible.GASOLINA,LocalDate.of(2018,9,4),TipoDeVehiculo.AUTOMOVIL);
		Parking p=new Parking();

		System.out.println(p.annyadirVehiculo(v1));
		System.out.println(p.annyadirVehiculo(v2));
		System.out.println(p.annyadirVehiculo(v3));
		System.out.println(p.annyadirVehiculo(v4));
		System.out.println(p.arrayToString());
		System.out.println(p.sacarVehiculo("DFGH4434"));
		
		System.out.println(p.arrayToString());
		System.out.println(p.comparaPorFecha());
		System.out.println(p.compararMarcaModelo());
		System.out.println(p.compararMatricula());
		System.out.println(p.compararTipoyCombustible());
	}
}
