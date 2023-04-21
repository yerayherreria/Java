package collections.boletin1.ejercicio7.model;

public class Cliente {
	private int numeroCaja;
	private int numeroCliente;
	private static int cont=1;
	
	public Cliente() {
		super();
		this.numeroCliente=cont++;
	}
	
	public void asignarCaja(int num) {
		this.numeroCaja=num;
	}

	public int getNumeroCliente() {
		return numeroCliente;
	}
}