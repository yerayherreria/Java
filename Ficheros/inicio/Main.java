package ficheros.inicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File fichero1= new File("C:\\Users\\Yeray\\Desktop\\Carpetitas\\ficheropro\\new File1.txt");

		try {
			BufferedReader buffer= new BufferedReader(new FileReader(fichero1));

			String linea= buffer.readLine();
			while(linea!=null) {
				System.out.println(linea);
				linea=buffer.readLine();
			}
			buffer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}

}
