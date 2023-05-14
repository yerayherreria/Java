package plataforma.online.jacaranda.com;

import java.util.Comparator;

public class ComparatorNumeroCapitulos implements Comparator<Temporada> {

	@Override
	public int compare(Temporada arg0, Temporada arg1) {
		
		return arg0.getNumeroCapitulos()-arg1.getNumeroCapitulos();
	}

}
