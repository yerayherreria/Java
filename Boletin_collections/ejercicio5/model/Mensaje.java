package collections.boletin1.ejercicio5.model;

import java.time.LocalDateTime;

public class Mensaje implements Comparable<Mensaje> {
	private Persona remitente;
	private String texto;
	private LocalDateTime envio;
	private static int cont;
	private int numeroCodigo;
	
	public Mensaje(Persona remitente, String texto) {
		super();
		this.remitente = remitente;
		this.texto = texto;
		this.envio = LocalDateTime.now();
		this.numeroCodigo = cont++;
	}
	

	@Override
	public String toString() {
		return "Mensaje " + this.numeroCodigo + ": De: " + remitente.getNombre() + " Texto:" + this.texto + " Fecha y hora:" + this.envio;
	}

	@Override
	public int compareTo(Mensaje o) {
		return this.remitente.getNombre().compareTo(o.remitente.getNombre());
	}

	public int getNumeroCodigo() {
		return this.numeroCodigo;
	}

	public String getTexto() {
		return this.texto;
	}



	
	
}
