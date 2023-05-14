package plataforma.online.jacaranda.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Catalogo {

	private HashMap<String, Serie> mapSeries;
	
	/**
	 * Crea el objeto que nos servirá para tener las series
	 */
	public Catalogo() {
		mapSeries=new HashMap<String, Serie>();
	}
	
	public Catalogo(String ruta) {
		mapSeries=new HashMap<String, Serie>();
		
		try {
			FileReader fr=new FileReader(new File(ruta));
			BufferedReader br=new BufferedReader(fr);
			
			String linea = br.readLine();
			linea = br.readLine();
			
			String[] lineas;
			
			while(linea!=null) {
				lineas=linea.split(",");
				mapSeries.put(lineas[0],new Serie(lineas[1], Integer.valueOf(lineas[2]), Tema.valueOf(lineas[3])));
				
				
				linea = br.readLine();
			}
		} catch (IOException | NumberFormatException | SerieException e) {
			e.printStackTrace();
		} 
	}
	
	/** Añade una serie a la lista de series. Si existe una serie con el mismo nombre lanza una excpetion
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirSerie(String nombreSerie, int anno, Tema tema) throws SerieException {
		if (mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Ya existe esa serie");
		}
		Serie serie = new Serie(nombreSerie, anno, tema);
		mapSeries.put(serie.getNombreSerie(), serie);
	}
	
	
	/** Añade una temporada a la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirTemporada(String nombreSerie, String temporada) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirTemporada(temporada);
	}
	
	
	/** Añade un capítulo a la temporada de la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie o la temporada lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada(String nombreSerie, String temporada, String capitulo) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirCapituloTemporada(temporada, capitulo);

	}
	
	
	/** Valorar una temporada de la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie o la temporada lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void valorarTemporada(String nombreSerie, String temporada, int valoracion) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.valorarTemporada(temporada, valoracion);
	}
	
	/**
	 * Devuelve el número de temporadas que tiene la serie que se pasa por parámetro
	 * Si no existe la serie saltará la excepción.
	 * @param nombreSerie
	 * @return
	 * @throws SerieException
	 */

	public int numeroDeTemporadasDeUnaSerie(String nombreSerie) throws SerieException{
		int acum=0;
		if(this.mapSeries.containsKey(nombreSerie)) {
			acum=this.mapSeries.get(nombreSerie).numeroTemporadas();
		} else {
			throw new SerieException("No existe la serie.");
		}
		return acum;
	}
	
	
	
	/** Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese tema saltará la excepción. 
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarTema( String nombreSerie, Tema nuevoTema) throws SerieException {
		if(this.mapSeries.containsKey(nombreSerie) && !this.mapSeries.get(nombreSerie).getTema().equals(nuevoTema)) {
			this.mapSeries.get(nombreSerie).setTema(nuevoTema);
		} else {
			throw new SerieException("No existe la serie o es el mismo tema.");
		}
		
		
	}
	
	
	
	/**
	 * Devolverá un listado ordenado de forma creciente por el año de la serie. 
	 * Para cada serie se mostrará su nombre, año y número de temporadas. 
	 * Si no hay ninguna serie de ese tema saltará la excepción.
	 * @param tema
	 * @return
	 * @throws SerieException
	 */
	public  String listadoOrdenadoSeriesDeUnTema(Tema tema)  throws SerieException {
		StringBuilder sb=new StringBuilder();
		List<Serie> s = new ArrayList<>();
		
		for(String se: this.mapSeries.keySet()) {
			if(this.mapSeries.get(se).getTema().equals(tema)) {
				s.add(this.mapSeries.get(se));				
			}
		}
		
		Collections.sort(s,new ComparatorAnnioSerie());
		
		for (Serie se: s) {
			sb.append(se).append(System.lineSeparator());
		}
		return sb.toString();
	}
	
	public void cargarTemporadaCSV() {
		File f = new File("./file/Temporadas.csv");
		
		try {
			f.createNewFile();
			PrintWriter pw= new PrintWriter(f);
			
			pw.write("nombreSerie,nombreTemporada,numeroCapitulos,sumaOpiniones,numeroOpiniones"+System.lineSeparator());
			pw.write("-------------------------------------------------------------------------"+System.lineSeparator());
			
			for(Serie s: this.mapSeries.values()) {
				for(Temporada t:s.getTemporadas()) {
					pw.write(String.format("%s,%s,%s,%s,%s,%s", s.getNombreSerie(),t.getNombreTemporada(),t.getNumeroCapitulos(),t.getSumaOpiniones(),t.getNumeroOpiniones(),System.lineSeparator()));
				}
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void cargarSerieCSV() {
		File f = new File("./file/Serie.csv");
		
		try {
			f.createNewFile();
			PrintWriter pw= new PrintWriter(f);
			
			pw.write("nombreSerie,anno,tema"+System.lineSeparator());
			pw.write("---------------------"+System.lineSeparator());
			
			for(Serie s: this.mapSeries.values()) {
				pw.write(String.format("%s,%s,%s,%s,", s.getNombreSerie(),s.getAnno(),s.getTema(),System.lineSeparator()));
				
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void cargarCapitulosCSV() {
		File f = new File("./file/Capitulos.csv");
		
		try {
			f.createNewFile();
			PrintWriter pw= new PrintWriter(f);
			
			pw.write("nombreSerie,nombreTemporada,nombreCapitulo"+System.lineSeparator());
			pw.write("------------------------------------------"+System.lineSeparator());
			
			for(Serie s: this.mapSeries.values()) {
				for(Temporada t:s.getTemporadas()) {
					for(String c:t.getCapitulos()) {
						pw.write(String.format("%s,%s,%s,%s,", s.getNombreSerie(),t.getNombreTemporada(),c,System.lineSeparator()));						
					}
				}
				
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void generarXML(String ruta) {
		try {
			File archivo = new File(ruta);
			archivo.createNewFile();
		
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element nodeRaiz = doc.createElement("series");
			doc.appendChild(nodeRaiz);
			
			for(Serie s: this.mapSeries.values()) {
				Element serie = doc.createElement("serie");
				nodeRaiz.appendChild(serie);
			
				Element nombreSerie = doc.createElement("nombreSerie");
				nombreSerie.appendChild(doc.createTextNode(s.getNombreSerie()));
				serie.appendChild(nombreSerie);
				
				Element temporadas = doc.createElement("temporadas");
				serie.appendChild(temporadas);
				
				Element temporada = doc.createElement("temporada");
				temporadas.appendChild(temporada);
			
				for(Temporada t : s.getTemporadas()) {
					Element nombreTemporada = doc.createElement("nombreTemporada");
					nombreTemporada.appendChild(doc.createTextNode(t.getNombreTemporada()));
					temporada.appendChild(nombreTemporada);
					
					Element capitulos = doc.createElement("capitulos");
					temporada.appendChild(capitulos);
					
					Element numCapitulosTemporada = doc.createElement("numero");
					numCapitulosTemporada.appendChild(doc.createTextNode(""+t.getCapitulos().size()));
					capitulos.appendChild(numCapitulosTemporada);
					
					for(String str : t.getCapitulos()) {
						Element capitulo = doc.createElement("capitulo");
						Element nombreCap = doc.createElement("nombre");
						nombreCap.appendChild(doc.createTextNode(str));
						capitulo.appendChild(nombreCap);
						capitulos.appendChild(capitulo);
					}
					
				}
				Transformer optimus = TransformerFactory.newInstance().newTransformer();
				DOMSource source= new DOMSource(doc);	
				StreamResult result= new StreamResult(new File(ruta));
				
				optimus.setOutputProperty(OutputKeys.INDENT, ("yes"));
				optimus.transform(source, result);
				
	
			}
		} catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError | IOException e) {
			e.printStackTrace();
		}
	}

	
}
