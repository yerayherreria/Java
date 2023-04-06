package empresaIT.comparables;

import java.util.Comparator;

import empresaIT.model.Candidate;

public class ComparatorExperiencia implements Comparator<Candidate> {

	@Override
	public int compare(Candidate o1, Candidate o2) {
		int resultado=0;
		if(o1!=null && o2!=null) {
			resultado = o1.getStartDate().isAfter(o2.getStartDate())?1:-1;
		}else if(o1==null) {
			resultado = 1;
		}else if(o2==null) {
			resultado = -1;
		}
		
		return resultado;
	}

}
