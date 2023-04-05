package alquilerVehiculos.model;

public enum Combustible {
	GASOLINA(3.5),DIESEL(2);
	
	private double precioBase;
	
	Combustible(double i) {
		this.precioBase=i;
	}

	public double getPrecioBase() {
		return precioBase;
	}
}
