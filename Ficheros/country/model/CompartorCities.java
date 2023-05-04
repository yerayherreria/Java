package ficheros.country.model;

import java.util.Comparator;

public class CompartorCities<T> implements Comparator<City> {

	@Override
	public int compare(City o1, City o2) {
		int resultado=0;
		if (o1.getAddress() == o2.getAddress()) {
			resultado=o1.getCity().compareTo(o2.getCity());
		} else {
			resultado=o1.getAddress() - o2.getAddress();
				
		}
		return resultado;
	}

}
