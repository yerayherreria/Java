package ficheros.country.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {

	private String id;
	private String city;
	private List<Address> address;
	
	public City(String id, String city) throws IOException {
		super();
		this.id = id;
		this.city = city;
		this.address = new ArrayList<>();
		addAddress();
	}
	
	public String getCity() {
		return city;
	}
	
	public int getAddress() {
		return this.address.size();
	}
	private void addAddress() throws IOException {
		FileReader f = new FileReader(new File("C:\\Users\\Yeray\\Desktop\\Carpetitas\\ficheropro\\address.txt"));
		BufferedReader b = new BufferedReader(f);
		String[] lineas;
		
		String linea = b.readLine();
		linea = b.readLine();
		while(linea!=null) {
			lineas=linea.split(",");
			try {
				if(lineas[4].equals(this.id)) {
					this.address.add(new Address(lineas[0], lineas[1]));
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			linea = b.readLine();

		}
		b.close();
		
	}

	public String addressToString() {
        StringBuilder sb = new StringBuilder();
        for(Address a : this.address) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(address, city, id);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales=this==obj;
		
		if(!sonIguales && obj!=null && obj instanceof City) {
			City other = (City) obj;
			sonIguales= Objects.equals(address, other.address) && Objects.equals(city, other.city)
					&& Objects.equals(id, other.id);
		}
		
		return sonIguales;
	}

	@Override
	public String toString() {
		return "\n"
				+ "	City con id " + id + " y ciudad " + city + " y direccion " + addressToString();
	}
}
