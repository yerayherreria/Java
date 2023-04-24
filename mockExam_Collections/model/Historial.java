package collections.mockExam_Collections.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import collections.boletin1.ejercicio4.exception.HistorialException;

public class Historial {
	private Map<LocalDate,Combinacion> sorteos;
	
	public Historial() {
		this.sorteos = new HashMap<>();
	}
	
	public boolean addSorteo(LocalDate fecha,Combinacion c) throws HistorialException {
		boolean resultado=false;
		if(c!=null && fecha!=null && !this.sorteos.containsKey(fecha)) {
			this.sorteos.put(fecha, c);
			resultado=true;
		} else {
			throw new HistorialException("Error.El sorteo ya existe o los datos no son válidos");
		}
		return resultado;
	}
	
	public boolean addSorteo(int dia,int mes,int annyo,Combinacion c) throws HistorialException {
		LocalDate fecha = LocalDate.of(annyo, mes, dia);
		return addSorteo(fecha, c);
	}
	
	public boolean actualizarSorteo(LocalDate fecha, Combinacion c) throws HistorialException {
		boolean resultado=false;
		if (fecha!=null && c!=null) {
			resultado=this.sorteos.replace(fecha, c)!=null;
		} else {
			throw new HistorialException("Error. Valores no válidos.");
		}
		return resultado;
	}
	
	public boolean actualizarSorteo(int dia,int mes,int annyo, Combinacion c) throws HistorialException {
		LocalDate fecha = LocalDate.of(annyo, mes, dia);
		return actualizarSorteo(fecha, c);
	}
	
	public boolean borrarSorteo(LocalDate fecha) throws HistorialException {
		boolean resultado=false;
		if (fecha!=null) {
			resultado=true;
			this.sorteos.remove(fecha);
		} else {
			throw new HistorialException("Error. Valores no válidos.");
		}
		return resultado;
	}
	
	public List<String> listarSorteoDesdeFecha(LocalDate fecha) {
		List<String> sorteo = new ArrayList<>();
	
		if(fecha!=null) {
			for(LocalDate s: this.sorteos.keySet()) {
				if(s.isAfter(fecha)) {
					sorteo.add(this.sorteos.get(s).toString());
				}
			}
		}
		return sorteo;
	}
	public List<String> mostrarHistorico() {
		List<String> sorteo = new ArrayList<>();
		
		for(LocalDate s: this.sorteos.keySet()) {
			sorteo.add(this.sorteos.get(s).toString());
		}
		return sorteo;
	}
	
	public Map<String,Integer> comprobarAciertos(LocalDate fecha,Combinacion c) throws HistorialException{
		Map<String,Integer> aciertos = new HashMap<>();
		
		if(fecha!= null && this.sorteos.containsKey(fecha)) {
			aciertos.put(fecha.toString(), this.sorteos.get(fecha).comprobarCombinacion(c));
		} else {
			throw new HistorialException("Error.El sorteo ya existe o los datos no son válidos");
		}
		return aciertos;
	}
	
	
}
