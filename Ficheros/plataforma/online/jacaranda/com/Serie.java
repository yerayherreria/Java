package plataforma.online.jacaranda.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Serie {
	private static final int ANNO_MINIMO = 1900; // Sólo se almacenrará series posteriores a 1900
	private String nombreSerie; // Nombre de la serie
	private int anno; //Año de la primera temporada de la serie
	private Tema tema; // Tema de la serie
	private ArrayList<Temporada> temporadas; // Lista de las temporadas de las series.
	
	
	/**
	 * Constructor que recibe el nombre de la serie, el año de creación y el tema.  Se crea la serie sin ninguna temporada
	 * @param nombreSerie
	 * @param anno
	 * @param tema
	 * @throws SerieException: si el año es anterior a 1900 se lanzará una exception
	 */
	public Serie(String nombreSerie, int anno, Tema tema) throws SerieException {
		super();
		this.nombreSerie = nombreSerie;
		setAnno(anno);
		this.tema = tema;
		temporadas=new ArrayList<Temporada>();
	}
	
	/**
	 * Añade una nueva temporada. Se le pasará el nombre de la nueva temporada y se añadirá al final.
	 * Debe comprobar que no existe un temporada con ese nombre en cuyo caso saltará la excepción.
	 * @param nombreTemporada
	 * @throws SerieException
	 */
	public void annadirTemporada( String nombreTemporada) throws SerieException {
		if(this.temporadas.contains(nombreTemporada)) {
			throw new SerieException("La temporada ya existe.");
		}
		this.temporadas.add(new Temporada(nombreTemporada));
	}
	
	
	/**
	 * Añade un nuevo capítulo a una temporada. Se le pasará el nombre de la temporada y si la temporada no existe
	 * se lanzará una exception
	 * @param nombreTemporada
	 * @param nombreCapitulo
	 * @throws SerieException
	 */
	
	public void annadirCapituloTemporada( String nombreTemporada, String nombreCapitulo) throws SerieException {
		int pos = encontrarTemporada(nombreTemporada);
		if (pos == -1) {
			throw new SerieException("No existe la temporada");
		}
		temporadas.get(pos).annadirCapitulo(nombreCapitulo);
	}
	
	private int encontrarTemporada(String nombreTemp) {
		int pos = -1;
		for(int i=0;i<this.temporadas.size();i++) {
			if(this.temporadas.get(i).getNombreTemporada().equals(nombreTemp)) {
				pos=i;
			}
		}
		return pos;
	}
	/**
	 * Valorar temporada. Si no exsite la temporada lanza una exception.
	 * @param nombreTemporada
	 * @param valoracion
	 * @throws SerieException
	 */
	
	public void valorarTemporada(String nombreTemporada, int valoracion) throws SerieException {
		Temporada temporada = new Temporada(nombreTemporada);
		int pos = temporadas.indexOf(temporada);
		if (pos == -1) {
			throw new SerieException("No existe la temporada");
		}
		temporadas.get(pos).valorar(valoracion);
		
	}
	/**
	 * Devuelve un listado de las temporadas de una serie ordenadas  de mayor a menor por nota media. 
	 * De cada temporada se mostrará el nombre, número de capítulos y nota media
	 * @return
	 */
	public String listadoTemporadasPorNotaMedia() {
		StringBuilder sb = new StringBuilder();
		Collections.sort(this.temporadas);
		
		for(Temporada t: this.temporadas) {
			sb.append(t).append(System.lineSeparator());
		}
		return sb.toString();
	}
	

	/**
	 * Devuelve un listado de las temporadas de una serie ordenadas de menor a mayor por número de capítulos. 
	 * De cada temporada se mostrará el nombre, número de capítulos y nota media.
	 * @return
	 */
	public String listadoTemporadasPorNumeroDeCapitulos() {
		StringBuilder sb = new StringBuilder();
		Collections.sort(this.temporadas,new ComparatorNumeroCapitulos());
		
		for(Temporada t: this.temporadas) {
			sb.append(t).append(System.lineSeparator());
		}
		return sb.toString();
	}

	
	/**
	 * Devuelve el nombre de la Serie
	 * @return
	 */
	public String getNombreSerie() {
		return nombreSerie;
	}


	/** Asigna el nombre de la serie
	 * 
	 * @param nombreSerie
	 */
	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}


	/**
	 * Devuelve el año
	 * @return
	 */
	public int getAnno() {
		return anno;
	}


	/**
	 * Asinga el año
	 * @param anno
	 * @throws SerieException
	 */
	public void setAnno(int anno) throws SerieException {
		if ( anno < ANNO_MINIMO) {
			throw new SerieException("Anno incorrecto");
		}
		this.anno = anno;
	}

	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}

	/**
	 * Devuelve el tema
	 * @return
	 */
	public Tema getTema() {
		return tema;
	}

	/** Asinga el tema
	 * 
	 * @param tema
	 */
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	/** 
	 * Devuelve el número de temporadas que tiene la serie
	 * @return
	 */
	public int numeroTemporadas() {
		return temporadas.size();
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return  "Serie " + nombreSerie + " Anno " + anno + " Tema " + tema + "Numero temporadadas " + numeroTemporadas();
	}

	@Override
	public int hashCode() {
		return Objects.hash(anno, nombreSerie, tema, temporadas);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj;
		
		if(!sonIguales && this!=null && obj instanceof Serie) {
			Serie other = (Serie) obj;
			sonIguales = anno == other.anno && Objects.equals(nombreSerie, other.nombreSerie) && tema == other.tema
					&& Objects.equals(temporadas, other.temporadas);			
		}
		return sonIguales;
	}


}
