package pooavanzado.parking.model;

import java.util.Arrays;

import pooavanzado.parking.comparable.ComparableMarcaModelo;
import pooavanzado.parking.comparable.ComparableMatricula;
import pooavanzado.parking.comparable.ComparableTipoyCombustible;

public class Parking {
	private Vehiculo[] vehiculo;
	private final static int CAPACIDAD_MAX=50;
	
	public Parking() {
		super();
		this.vehiculo=new Vehiculo[CAPACIDAD_MAX];
	}
	public boolean annyadirVehiculo(Vehiculo v) {
		boolean esAnnyadido=false;
		for (int i=0; i<vehiculo.length && !esAnnyadido; i++) {
			if (vehiculo[i] == null) {
				vehiculo[i]=v;
				esAnnyadido=true;
			}
		}
		return esAnnyadido;
	}
	public boolean sacarVehiculo(String matricula) {
		boolean esSacado=false;
		for (int i=0; i<vehiculo.length && !esSacado; i++) {
			if (vehiculo[i] != null && matricula.equals(vehiculo[i].getMatricula())) {
				vehiculo[i]=null;
				esSacado=true;
			}
		}
		return esSacado;
	}
	private Vehiculo[] quitarNulosArray() {
		int contVeh = 0;
		for(Vehiculo v: this.vehiculo) {
			if(v != null) {
				contVeh ++;
			}
		}

		Vehiculo[] tmp = new Vehiculo[contVeh];
		int indice = 0;
		for(int i = 0; i < this.vehiculo.length; i++) {
			if(this.vehiculo[i] != null) {
			tmp[indice] = this.vehiculo[i];
			indice ++;
			}
		}
		return tmp;

	}
	public String arrayToString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<vehiculo.length; i++) {
			if (vehiculo[i]!=null) {
				sb.append(vehiculo[i]).append("\n");
			}
		}
		return sb.toString();
	}
	public String comparaPorFecha() {
		Vehiculo[] vehiculoNoNulo = quitarNulosArray();
		Arrays.sort(vehiculoNoNulo);
		return Arrays.toString(vehiculoNoNulo);
	}
	public String compararMarcaModelo() {
		Arrays.sort(this.vehiculo, new ComparableMarcaModelo());
		return Arrays.toString(this.vehiculo);
	}
	public String compararTipoyCombustible() {
		Arrays.sort(this.vehiculo, new ComparableTipoyCombustible());
		return Arrays.toString(this.vehiculo);
	}
	public String compararMatricula() {
		Arrays.sort(this.vehiculo, new ComparableMatricula());
		return Arrays.toString(this.vehiculo);
	}
}
