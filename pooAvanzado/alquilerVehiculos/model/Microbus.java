package alquilerVehiculos.model;

import alquilerVehiculos.excepciones.MicronbusException;

public class Microbus extends Vehiculo {
	private int plaza;
	
	public Microbus(String matricula, Gama gama, int plaza) throws MicronbusException {
		super(matricula, gama);
		if(plaza>0) {
			this.plaza=plaza;
			super.precioBase+=(plaza*5);
		} else {
			throw new MicronbusException("Error. Las plazas tiene que ser mayor a 0.");
		}
	}
	
	@Override
	public String toString() {
		return super.toString().concat("y de "+plaza+" plazas.");
	}

}
