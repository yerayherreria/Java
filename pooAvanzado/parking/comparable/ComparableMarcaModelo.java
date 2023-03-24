package pooavanzado.parking.comparable;

import java.util.Comparator;

import pooavanzado.parking.model.Vehiculo;

public class ComparableMarcaModelo implements Comparator<Vehiculo>{
	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		int resultado = 0;
		if(o1 != null && o2 != null) {
			resultado=o1.getMarca().compareTo(o2.getMarca());
			if( o1.getMarca().compareTo(o2.getMarca())==0) {
				resultado=o1.getModelo().compareTo(o2.getModelo());
			}
		}else if(o2 == null){
			resultado = -1;
		}else if(o1 == null) {
			resultado = 1;
		}
		return resultado;
	}
}
