package collections.boletin1.ejercicio7.comparator;

import java.util.Comparator;

import collections.boletin1.ejercicio7.model.Caja;

public class CompartorCajas implements Comparator<Caja> {

	@Override
	public int compare(Caja o1, Caja o2) {
		int resultado=0;
		if(o1!=null && o2!=null) {
			if(o1.getClientes()==o2.getClientes()) {
				resultado = o1.getNumeroCaja()-o2.getNumeroCaja();
			}else {
				resultado = o1.getClientes()-o2.getClientes();
			}
		} else if (o1==null) {
			resultado=-1;
		} else if (o2==null) {
			resultado=1;
		}
		return resultado;
	}

}
