package plataforma.online.jacaranda.com;

import java.util.LinkedList;
import java.util.Objects;

public class Temporada implements Comparable<Temporada>{
	
	private String nombreTemporada;  // Nombre de las temporada
	private LinkedList<String> capitulos; // Lista donde etán los nombres de los capítulos de la temporada
	private int sumaOpiniones;  // Suma de todas las opiniones que se han realizado de la temporada
	private int numeroOpiniones; // Número de opiniones que se han realizado de la temporada
	
	/**
	 * Constructor de una temporada. Se crea sin ningún capítulo.
	 * @param nombreTemporada: recibe el nombre de la temporada.
	 * Obviamente no se ha realizado ninguna opinión sobre la temporada
	 */
	
	public Temporada(String nombreTemporada) {
		this.nombreTemporada=nombreTemporada;
		capitulos=new LinkedList<String>();
		sumaOpiniones=0;
		numeroOpiniones=0;
	}
	
	public String getNombreTemporada() {
		return nombreTemporada;
	}

	public int getNumeroCapitulos() {
		return this.capitulos.size();
	}
	
	public int getSumaOpiniones() {
		return sumaOpiniones;
	}

	public int getNumeroOpiniones() {
		return numeroOpiniones;
	}

	public LinkedList<String> getCapitulos() {
		return capitulos;
	}

	/**
	 * Método que añade un capítulo a la temporada. Se añade al final de los capítulos existente.
	 * No hay ningún control por lo que puede pasar que existan capítulos con el mismo nombre
	 * @param capitulo: nombre del capítulo a añadir
	 */
	public void annadirCapitulo(String capitulo) {
		capitulos.add(capitulo);
	}
	
	/**
	 * Elimna un capítulo de la temporada. Devuelve true si el capítulo estaba y se ha borrado, y 
	 * devuelve false si el capítulo no estába en la lista y por lo tanto no se ha podido borrar.
	 * @param capitulo: nombre del capítulo a borrar
	 * 
	 * 	 
	 * */
	
	public boolean eliminarCapitulo (String capitulo) {
		boolean borrado;
		borrado=capitulos.remove(capitulo);
		return borrado;
	}
	
	/**
	 * Métodoque valora la temporada. Los valores permitidos son de 0 a 10
	 * Se debe incrementar la suma de opiniones de la temporada y el número de valores
	 * que ha recibido la valoración
	 * @param nota
	 * @throws SerieException
	 */
	public void valorar( int nota)throws SerieException {
		if (nota < 0 || nota > 10) {
			throw new SerieException("Nota incorrecta "  + nota);
		}
		
		sumaOpiniones= sumaOpiniones + nota;
		numeroOpiniones++;
	}
	
	
	/**
	 * Debe añadir un capítulo justo detrás del capítulo que se denomina nombreCapituloAnterior.
	 * Si no encuentra el capítulo anterior  saltará la excepción
	 * @param nombreCapituloAnnadir: este será el nombre del capítulo que se añadirá
	 * @param nombreCapituloAnterior: detrás de este capítulo se debe añadir

	 * @throws SerieException: si no encuentra el capítulo que indica la posición para añadir.
	 */
	public void anadirCapituloDespues(String nombreCapituloAnnadir, String nombreCapituloAnterior) throws SerieException{
		boolean anniadido=false;
		if(nombreCapituloAnnadir!=null && nombreCapituloAnterior!=null) {
			for(int i=0; i<this.capitulos.size();i++) {
				if(this.capitulos.get(i).equals(nombreCapituloAnterior)) {
					this.capitulos.add(i, nombreCapituloAnnadir);
					anniadido=true;
				}
			}
		}
		if(!anniadido) {
			throw new SerieException("No se puede añadir capítulo.");
		}
		
	}
	

	/**
	 * Devuleve el nombre del primer capítulo que contiene la palabra que  pasa por parámetro.
	 *  Si no lo encuentra salta la excepción 
	 * @param palabra
	 * @return
	 * @throws SerieException
	 */
	public String primerCapituloQueContieneEstaPalabara(String palabra) throws SerieException {
		boolean encontrado = false;
		String resultado="";
		for(String c : this.capitulos) {
			if(c.contains(palabra) && !encontrado) {
				resultado = c;
				encontrado=true;
			}
		}
		if(!encontrado) {
			throw new SerieException("No se encuentra el capítulo.");
		}
		return resultado;
	}
	
	
	
	public double getNotaMedia() {
		double notaMedia=-1;
		if (numeroOpiniones!=0) {
			notaMedia= sumaOpiniones/numeroOpiniones;
		}
		return notaMedia;
	}
	
	public String toString() {
		return nombreTemporada+   " Número de capitulos " + capitulos.size() + 
				" Nota media " + getNotaMedia();
	}

	@Override
	public int hashCode() {
		return Objects.hash(capitulos, nombreTemporada, numeroOpiniones, sumaOpiniones);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj!=null && obj instanceof Temporada) {
			Temporada other = (Temporada) obj;
			sonIguales= Objects.equals(capitulos, other.capitulos) && Objects.equals(nombreTemporada, other.nombreTemporada)
					&& numeroOpiniones == other.numeroOpiniones && sumaOpiniones == other.sumaOpiniones;
			
		}
		return sonIguales;
	}

	@Override
	public int compareTo(Temporada o) {
		return (int) (this.getNotaMedia()-o.getNotaMedia());
	}

	

	
	
	
}
