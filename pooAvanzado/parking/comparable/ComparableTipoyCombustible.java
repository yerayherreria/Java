package pooavanzado.parking.comparable;

import java.util.Comparator;

import pooavanzado.parking.model.Vehiculo;

public class ComparableTipoyCombustible implements Comparator<Vehiculo>{
	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		int resultado = 0;
		if(o1 != null && o2 != null) {
			resultado=o1.getTipo().toString().compareTo(o2.getTipo().toString());
			if(o1.getTipo().toString().compareTo(o2.getTipo().toString())==0) {
				resultado=o1.getCombustible().toString().compareTo(o2.getCombustible().toString());
			}
		}else if(o2 == null){
			resultado = -1;
		}else if(o1 == null) {
			resultado = 1;
		}
		return resultado;
	}
}
