package ficheros.country.model;

import java.util.Objects;

public class Address implements Comparable<Address> {
	private String id;
	private String address;
	
	public Address(String id, String address) {
		super();
		this.id = id;
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, id);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		if(!sonIguales && obj!=null && obj instanceof Address) {
			Address other = (Address) obj;
			sonIguales = Objects.equals(address, other.address) && Objects.equals(id, other.id);
			
		}
		return sonIguales;
	}

	@Override
	public String toString() {
		return "\n"
				+ "		Address con id " + id + " y direccion " + address;
	}

	@Override
	public int compareTo(Address o) {
		return this.address.compareTo(o.address);
	}
	
	
}
