package pooavanzado.sieteymedia.model;

import java.util.Objects;

public class Carta implements Comparable<Carta>{
	
	private Palo palo;
	private int numero;
	
	public Carta(Palo palo, int numero) throws Exception {
		super();
		if (numero<1 || numero >12 || numero==8 || numero==9) {
			throw new Exception("Valor no válido");
		}
			this.palo = palo;
			this.numero = numero;
	}
	
	public double getValor() {
		return this.numero > 9 ? 0.5: this.numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, palo);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj;
		if (!sonIguales && obj!=null && obj instanceof Carta) {
			Carta other = (Carta) obj;
			sonIguales= numero == other.numero && palo == other.palo;
		}
		return sonIguales;
	}
	
	public Palo getPalo() {
		return palo;
	}

	public int getNumero() {
		return numero;
	}
	
	@Override
	public String toString() {
		return  this.numero + " de " + this.palo.toString().toLowerCase();
	}

	@Override
	public int compareTo(Carta o) {
		return this.numero-o.numero;
	}
	
}
