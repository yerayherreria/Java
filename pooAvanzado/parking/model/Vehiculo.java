package pooavanzado.parking.model;

import java.time.LocalDate;

public class Vehiculo implements Comparable<Vehiculo>{
	private String marca;
	private String modelo;
	private String matricula;
	private Combustible combustible;
	private LocalDate fechaDeEntrada;
	private TipoDeVehiculo tipo;
	private final int LONGITUD_MATRICULA=8;
	private final static int NUM_DIGITOS=4;

	public Vehiculo(String marca, String modelo, String matricula, Combustible combustible, LocalDate fechaDeEntrada,
			TipoDeVehiculo tipo) {
		super();
		if (esMatriculaValida(matricula)) {
			this.marca = marca;
			this.modelo = modelo;
			this.matricula = matricula;
			this.combustible = combustible;
			this.fechaDeEntrada = fechaDeEntrada;
			this.tipo = tipo;			
		}
	}
	
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Combustible getCombustible() {
		return combustible;
	}

	public LocalDate getFechaDeEntrada() {
		return fechaDeEntrada;
	}

	public TipoDeVehiculo getTipo() {
		return tipo;
	}

	public String getMatricula() {
		return matricula;
	}

	private boolean esMatriculaValida(String matricula) {
		boolean esValida=false;
		int cont=0;
		
		if (matricula.length()==LONGITUD_MATRICULA) {
			for (int i = 0;i < matricula.length(); i++) {
				if (Character.isDigit(matricula.charAt(i))) {
					cont++;
				}
			}
		} if (cont==NUM_DIGITOS) {
			esValida=true;
		}
		return esValida;	
	}
	
	public int compareTo(Vehiculo v) {
		int compare=2;
		if(v!=null) {
			compare=this.fechaDeEntrada.compareTo(v.fechaDeEntrada);
		}
		return compare;
	}
	@Override
	public String toString() {
		return "El vehiculo con marca " + marca + ", modelo " + modelo + ", matricula " + matricula + " de combustible "
				+ combustible + " con fecha de entrada " + fechaDeEntrada + " y de tipo " + tipo;
	}
}
