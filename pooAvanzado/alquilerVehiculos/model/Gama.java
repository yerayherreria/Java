package alquilerVehiculos.model;

public enum Gama {
	ALTA(50),MEDIA(40),BAJA(30);
	
	private double precioBase;
	
	Gama(double i) {
		this.precioBase=i;
	}

	public double getPrecioBase() {
		return precioBase;
	}
	
	
}
