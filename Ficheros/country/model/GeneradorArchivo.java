package ficheros.country.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorArchivo {
	private List<Country> countries;
	
	public GeneradorArchivo() throws IOException {
		this.countries= new ArrayList<>();
		addCountry();
	}
	
	private void addCountry() throws IOException {
		FileReader f = new FileReader(new File("C:\\Users\\Yeray\\Desktop\\Carpetitas\\ficheropro\\country.txt"));
		BufferedReader b = new BufferedReader(f);
		String[] lineas;
		
		String linea = b.readLine();
		linea = b.readLine();
		while(linea!=null) {
			lineas=linea.split(",");
			this.countries.add(new Country(lineas[0], lineas[1]));
      
			linea = b.readLine();

		}
		b.close();
		
	}
	
	public void generarArchivo() throws IOException {
		File f = new File("C:\\Users\\Yeray\\Desktop\\Carpetitas\\ficheropro\\generadociudad.txt");
		f.createNewFile();
		FileWriter filewr= new FileWriter(f);
		BufferedWriter bufferwr= new BufferedWriter(filewr);
		
		for(Country c:this.countries) {
			bufferwr.append(c.toString());
			bufferwr.newLine();
		}
		bufferwr.close();
		filewr.close();
	}
	
}
