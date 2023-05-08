package ficheros.feria.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

import ejerciciosMapeo.model.Persona;
import ficheros.country.model.Country;

public class Feria {
	private List<Caseta> casetas;
	
	public Feria(String ruta) {
		this.casetas=cargarCaseta(ruta);
	}
	
	public String obtenerCasetaPorCalle(String calle) {
		StringBuilder sb = new StringBuilder();
		for(Caseta c: this.casetas) {
			if(c.getCalle().equals(calle)) {
				sb.append(c).append("\n");
			}
		}
		return sb.toString();
	}
	
	public String obtenerCasetaFamiliar() {
		StringBuilder sb = new StringBuilder();
		for(Caseta c: this.casetas) {
			if(c.getClase().equals("FAMILIAR")) {
				sb.append(c).append("\n");
			}
		}
		return sb.toString();
	}
	
	public String obtenerCasetaDistrito() {
		StringBuilder sb = new StringBuilder();
		for(Caseta c: this.casetas) {
			if(c.getClase().equals("DISTRITO")) {
				sb.append(c).append("\n");
			}
		}
		return sb.toString();
	}
	
	public String obtenerCasetaNiDistritoNiFamiliares() {
		StringBuilder sb = new StringBuilder();
		for(Caseta c: this.casetas) {
			if(!c.getClase().equals("DISTRITO") && !c.getClase().equals("FAMILIAR")) {
				sb.append(c).append("\n");
			}
		}
		return sb.toString();
	}
	
	public String obtenerCasetaPorCalleFamiliar() {
		Map<String, Integer> mapaCallesFa = new HashMap<>();

        for(Caseta c : this.casetas) {
        	if(c.getClase().equals("FAMILIAR")) {
        		if(!mapaCallesFa.containsKey(c.getCalle())){
        			mapaCallesFa.put(c.getCalle(), 0);
        		}
        		mapaCallesFa.replace(c.getCalle(),mapaCallesFa.get(c.getCalle()) , mapaCallesFa.get(c.getCalle())+1);

        	}
    	}

        return mapaCallesFa.toString();
	
	}
	
	public String obtenerCasetaPorCalleDistrito() {
		Map<String, Integer> mapaCallesDis = new HashMap<>();

        for(Caseta c : this.casetas) {
        	if(c.getClase().equals("DISTRITO")) {
        		if(!mapaCallesDis.containsKey(c.getCalle())){
        			mapaCallesDis.put(c.getCalle(), 0);
        		}
        		mapaCallesDis.replace(c.getCalle(),mapaCallesDis.get(c.getCalle()) , mapaCallesDis.get(c.getCalle())+1);

        	}
    	}

        return mapaCallesDis.toString();
	}
	
	public void eliminarCaseta(String calle,String numero) throws Exception {
		Iterator<Caseta> it = this.casetas.iterator();
		boolean borrado=false;
		Caseta caseta=null;
		int modulo=0;
		
		while(it.hasNext() && !borrado) {
			caseta=it.next();
			if(caseta.getCalle().equals(calle) && caseta.getNumero().equals(numero)) {
				it.remove();
				modulo=Integer.valueOf(caseta.getModulos());
				borrado=true;
			} else if (Integer.valueOf(caseta.getModulos())>Integer.valueOf(numero) && caseta.getCalle().equals(calle)) {
				caseta.restarNumero(modulo);
			}
		}
		if(!borrado) {
			throw new Exception("No se ha podido borrar la caseta.");
		}
	}
	
	public void cargarJson() throws IOException{
		File f = new File("./ficheros/casetasf.json");
		f.createNewFile();
		
		Gson gson = new Gson();
		String casetasDatos = gson.toJson(this.casetas);

		BufferedWriter bufferwr= new BufferedWriter(new FileWriter(f));
		bufferwr.append(casetasDatos);
		bufferwr.close();
		
	}
	
	private List<Caseta> cargarCaseta(String ruta) {
		List<Caseta> cargarCasetas = new ArrayList<>();
		File fichero = new File(ruta);
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document documento = builder.parse(fichero);
			
			NodeList listaNodoCasetas = documento.getElementsByTagName("DatosLeidos");
			
			for (int i=0;i<listaNodoCasetas.getLength();i++) {
				Element node =(Element)listaNodoCasetas.item(i);
				
				String titulo = node.getElementsByTagName("TITULO").item(0).getTextContent();
				String calle = node.getElementsByTagName("CALLE").item(0).getTextContent();
				String numero = node.getElementsByTagName("NUMERO").item(0).getTextContent();
				String modulos = node.getElementsByTagName("MODULOS").item(0).getTextContent();
				String clase = node.getElementsByTagName("CLASE").item(0).getTextContent();
				String entidad = node.getElementsByTagName("ENTIDAD").item(0)!=null? node.getElementsByTagName("ENTIDAD").item(0).getTextContent():" ";

				String id = node.getElementsByTagName("ID").item(0).getTextContent();
				String id_calle = node.getElementsByTagName("ID_CALLE").item(0).getTextContent();
				
				Caseta c = new
						Caseta(titulo,calle,numero,modulos,clase,entidad,id,id_calle);
				
				cargarCasetas.add(c);
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return cargarCasetas;
	}

}
