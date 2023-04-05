package alquilerVehiculos.model;

public class Coche extends Vehiculo {

	private Combustible combustible;
	
	public Coche(String matricula, Gama gama, Combustible combustible) {
		super(matricula, gama);
		this.combustible = combustible;
		super.precioBase += combustible.getPrecioBase();
	}

	@Override
	public String toString() {
		return super.toString().concat("y de "+ combustible);
	}

}
