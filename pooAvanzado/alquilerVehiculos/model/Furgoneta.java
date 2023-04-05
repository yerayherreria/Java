package alquilerVehiculos.model;

import alquilerVehiculos.excepciones.FurgonetaException;

public class Furgoneta extends Vehiculo {

	private double pma;
	
	public Furgoneta(String matricula, Gama gama, double pma) throws FurgonetaException {
		super(matricula, gama);
		if(pma>0) {
			this.pma=pma;
			super.precioBase+=(pma*0.5);
		} else {
			throw new FurgonetaException("Error. El PMA tiene que ser mayor a 0.");
		}
	}
	
	@Override
	public String toString() {
		return super.toString().concat("y el PMA es "+pma+".");
	}
}
