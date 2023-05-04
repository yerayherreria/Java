package ficheros.country.model;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			GeneradorArchivo gr = new GeneradorArchivo();
			gr.generarArchivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
