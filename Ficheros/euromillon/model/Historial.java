package ficheros.euromillon.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Historial {

	private Map<LocalDate, Combinacion> sorteos;
	
	
	public Historial() {
		super();
		this.sorteos= new HashMap<>(); 
	}
	
	public boolean addSorteo(LocalDate fecha, Combinacion c) throws HistorialException {
		if(this.sorteos.containsKey(fecha)) {
			throw new HistorialException("Ya existe un sorteo para la fecha indicada");
		}
		this.sorteos.put(fecha, c);
		return true;
	}
	
	
	public boolean addSorteo(int year, int month, int day, Combinacion c) throws HistorialException{
		return addSorteo(LocalDate.of(year, month, day), c);
	}
	
	public void addSorteo(String linea) throws CombinacionException {
		String[] li = linea.split(",");
		String[] numeros = Arrays.copyOfRange(li, 1, 6);
		String[] estrellas = Arrays.copyOfRange(li, 7, 9);
		this.sorteos.put(LocalDate.parse(li[0], DateTimeFormatter.ofPattern("d/MM/yyyy")), new Combinacion(numeros,estrellas));
	}
	
	public boolean actualizarSorteo(LocalDate fecha, Combinacion c) throws HistorialException {
		if(!this.sorteos.containsKey(fecha)) {
			throw new HistorialException("No existe un sorteo para la fecha indicada");
		}
		this.sorteos.put(fecha, c);
		return true;
	}
	
	public boolean actualizarSorteo(int year, int month, int day, Combinacion c) throws HistorialException{
		return actualizarSorteo(LocalDate.of(year, month, day), c);
	}
	
	
	public boolean borrarSorteo(LocalDate fecha) throws HistorialException {
		if(!this.sorteos.containsKey(fecha)) {
			throw new HistorialException("No existe un sorteo para la fecha indicada");
		}
		this.sorteos.remove(fecha);
		return true;
	}
	
	
	public List<String> listarSorteosDesdeFecha(LocalDate fechaInicio){
		List<String> sorteos = new ArrayList<>();
		for(LocalDate f : this.sorteos.keySet()) {
			if(fechaInicio==null || f.isAfter(fechaInicio) ) {
				sorteos.add( f.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+" "+
						this.sorteos.get(f).toString());
			}
		}
		
		return sorteos;
	}
	
	
	public List<String> mostrarHistorico(){
		return listarSorteosDesdeFecha(null);
	}
	
	public List<String> listarSorteosDesdeFechaOrdenados(LocalDate fechaInicio){
		//Alternativa utilizar TreeMap
		List<LocalDate> listaFechas = new ArrayList<>();
		for(LocalDate f : this.sorteos.keySet()) {
			if(fechaInicio==null || f.isAfter(fechaInicio)) {
				listaFechas.add(f);
			}
		}
		Collections.sort(listaFechas);
		
		List<String> sorteos = new ArrayList<>();
		for(LocalDate f : listaFechas) {
			sorteos.add(this.sorteos.get(f).toString());
			
		}
		return sorteos;
	}
	
	public List<String> mostrarHistoricoOrdenado(){
		return listarSorteosDesdeFechaOrdenados(null);
	}
	
	public Map<String, Integer> comprobarAciertos(LocalDate fecha, Combinacion combinacion) throws HistorialException{
		Map<String, Integer> aciertos = new HashMap<>();
		
		if(!this.sorteos.containsKey(fecha)) {
			throw new HistorialException();
		}
		
		aciertos.put(fecha.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")), 
				this.sorteos.get(fecha).comprobarCombinacion(combinacion));
		
		return aciertos;
	}

	@Override
	public String toString() {
		return "Historial [sorteos=" + sorteos + "]";
	}
	
	//Fichero EuroMillones
	
	private Map<Integer, Integer> contarNumeros(){
		Map<Integer, Integer> numVecesRepetidos = new HashMap<>();
		
		for(LocalDate f:this.sorteos.keySet()) {
			for(Integer n : this.sorteos.get(f).getNumeros()) {
				if(!numVecesRepetidos.containsKey(n)) {
					numVecesRepetidos.put(n, 0);
				}
				numVecesRepetidos.put(n, numVecesRepetidos.get(n)+1);
			}
		}
		return numVecesRepetidos;
	}
	
	private Map<Integer, Integer> contarEstrellas(){
		Map<Integer, Integer> numVecesRepetidos = new HashMap<>();
		
		for(LocalDate f:this.sorteos.keySet()) {
			for(Integer n : this.sorteos.get(f).getEstrellas()) {
				if(!numVecesRepetidos.containsKey(n)) {
					numVecesRepetidos.put(n, 0);
				}
				numVecesRepetidos.put(n, numVecesRepetidos.get(n)+1);
			}
		}
		return numVecesRepetidos;
	}
	
	private Set<Integer> extraerMax(Map<Integer, Integer> num) {
		Set<Integer> numM= new HashSet<>();
		numM.add(1);
		for (Integer n: num.keySet()) {
			for(Integer n2 :numM) {
				if(num.get(n)>num.get(n2)) {
					numM.clear();
					numM.add(n);
				}
			}
		}
		return numM;
	}
	
	private Set<Integer> extraerMin(Map<Integer, Integer> num) {
		Set<Integer> numM= new HashSet<>();
		numM.add(1);
		for (Integer n: num.keySet()) {
			for(Integer n2 :numM) {
				if(num.get(n)<num.get(n2)) {
					numM.clear();
					numM.add(n);
				}
			}
		}
		return numM;
	}

	private int extraerSecuencia(Combinacion c) {
		int cont=0,anterior=-1;
		
		for(int n:c.getNumeros()) {
			if(n==anterior+1) {
				cont++;
			}
			anterior=n;
		}
		return cont;
	}
	
	public Set<Integer> numMax() {
		Map<Integer,Integer> num = contarNumeros();
		Set<Integer> numM = extraerMax(num);
		
		return numM;
	}

	
	public Set<Integer> numMin() {
		Map<Integer,Integer> num = contarNumeros();
		Set<Integer> numM = extraerMin(num);
		
		return numM;
	}

	
	public Set<Integer> estreMax() {
		Map<Integer,Integer> est = contarEstrellas();
		Set<Integer> numM = extraerMax(est);
		
		return numM;
	}
	
	public Set<Integer> estreMin() {
		Map<Integer,Integer> est = contarEstrellas();
		Set<Integer> numM = extraerMin(est);
		
		return numM;
	}
	
	public int maxAcierto(Combinacion c) {
		int acum=0;
		Set<Combinacion> co = new HashSet<>(this.sorteos.values());
		
		for(Combinacion c1: co) {
			if(c.comprobarCombinacion(c1)>acum) {
				acum=c.comprobarCombinacion(c1);
			}
		}
		return acum;
	}
	
	public int numSecuenciaCombinacion() {
		List<Combinacion> c = new ArrayList<>(this.sorteos.values());
		int acum =0;
		
		for (Combinacion c2:c) {
			if(extraerSecuencia(c2)>acum) {
				acum=extraerSecuencia(c2);
			}
		}
		return acum;
	}
	
}
