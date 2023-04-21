package collections.boletin1.ejercicio4.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import collections.boletin1.ejercicio4.exception.HistorialException;

public class Historial {
	
	private List<PaginaWeb> historialVisita;

	public Historial() {
		this.historialVisita = new ArrayList<>();
	}
	
	public void annyadirWeb(PaginaWeb pagina) throws HistorialException {
		if(this.historialVisita.isEmpty()) {
			this.historialVisita.add(pagina);
		}else if(this.historialVisita.get(this.historialVisita.size()-1).getFechayhora().isBefore(pagina.getFechayhora())){
			this.historialVisita.add(pagina);
		}else {
			throw new HistorialException("Error. Fecha y hora anterior a la última añadida.");
		}
	}
	
	public Historial mostrarHistorial() {
		return this;
	}
	
	public Historial mostrarHistorialPorDia(int dia) throws HistorialException {
		Historial tmp = new Historial();
		for(PaginaWeb pw: this.historialVisita) {
			if(pw!=null && dia>0 && dia<31 && pw.getFechayhora().getDayOfMonth()==dia) {
				tmp.annyadirWeb(pw);
			}
		}
		return tmp;
	}
	
	public void borrarHistorial() {
		this.historialVisita.clear();
	}
	
	public void borrarHistorialVista(String web) {
		Iterator<PaginaWeb> pw = this.historialVisita.iterator();
		if(web!=null) {
			while(pw.hasNext()) {
				if(pw.next().getUrl().equals(web)) {
					pw.remove();
				}
			}
		}
	}

	@Override
	public String toString() {
		return historialVisita.toString();
	}
	
	
	
}
