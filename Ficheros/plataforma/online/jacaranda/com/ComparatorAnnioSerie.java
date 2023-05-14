package plataforma.online.jacaranda.com;

import java.util.Comparator;

public class ComparatorAnnioSerie implements Comparator<Serie> {

	@Override
	public int compare(Serie o1, Serie o2) {
		return o1.getAnno()-o2.getAnno();
	}

}
