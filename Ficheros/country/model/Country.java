package ficheros.country.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Country {
	private String id;
	private String country;
	private List<City> cities;
	
	public Country(String id, String country) throws IOException {
		super();
		this.id = id;
		this.country = country;
		this.cities = new ArrayList<>();
		addCity();
		Collections.sort(this.cities,new CompartorCities<>());
	}
	
	private void addCity() throws IOException {
		FileReader f = new FileReader(new File("C:\\Users\\Yeray\\Desktop\\Carpetitas\\ficheropro\\city.txt"));
		BufferedReader b = new BufferedReader(f);
		String[] lineas;
		
		String linea = b.readLine();
		linea = b.readLine();
		while(linea!=null) {
			lineas=linea.split(",");
			 if(lineas[2].equals(this.id)) {
                 this.cities.add(new City(lineas[0], lineas[1]));
             }
			linea = b.readLine();

		}
		b.close();
		
	}
	
	public String citiesToString() {
        StringBuilder sb = new StringBuilder();
        for(City c : this.cities) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(cities, country, id);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales=this==obj;
		if(!sonIguales && obj!=null && obj instanceof Country) {
			Country other = (Country) obj;
			sonIguales= Objects.equals(cities, other.cities) && Objects.equals(country, other.country)
					&& Objects.equals(id, other.id);
			
		}
		return sonIguales;
	}

	@Override
	public String toString() {
		return "\n"
				+ "Country con id " + id + ", nombre " + country + ", cities " + citiesToString();
	}
	
}
