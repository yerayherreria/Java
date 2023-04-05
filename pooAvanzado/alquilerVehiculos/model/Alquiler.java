package alquilerVehiculos.model;

import alquilerVehiculos.excepciones.AlquilerException;

public class Alquiler {
	private static final int NUM_MAX_COCHES = 200;
	Vehiculo[] vehiculos;
	private double precio;
	private double numAlquiler;
	
	public Alquiler() {
		vehiculos = new Vehiculo[NUM_MAX_COCHES];
	}
	
	private int buscarVehiculo(String matricula) {
		int posicion = -1;
		for(int i=0; i<vehiculos.length && posicion!=-1; i++) {
			if(this.vehiculos[i].getMatricula().equals(matricula)) {
				posicion = i;
			}
		}
		return posicion;
	}
	
	public boolean altaVehiculo(Vehiculo vehiculo) throws AlquilerException {
		boolean alta = false;
		if(numAlquiler<NUM_MAX_COCHES) {
			for(int i=0; i<vehiculos.length && !alta; i++) {
				if(this.vehiculos[i] == null) {
					this.vehiculos[i] = vehiculo;
					alta=true;
					numAlquiler++;
				}
			}
			return alta;			
		} else {
			throw new AlquilerException("Error. No hay más espacio para alquileres.");
		}
	}
	
	public double calcularPrecioAlquiler(String matricula,int dia) {
		if(buscarVehiculo(matricula)!=-1) {
			this.precio = this.vehiculos[buscarVehiculo(matricula)].precioBase*dia;
		}
		return this.precio;
	}
}
