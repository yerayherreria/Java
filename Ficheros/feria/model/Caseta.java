package ficheros.feria.model;

import java.util.Objects;

public class Caseta implements Comparable<Caseta> {
	private String titulo;
	private String calle;
	private String numero;
	private String modulos;
	private String clase;
	private String entidad;
	private String id;
	private String id_calle;
	
	public Caseta(String titulo, String calle, String numero, String modulos, String clase, String entidad, String id, String id_calle) {
		super();
		this.titulo = titulo;
		this.calle = calle;
		this.numero = numero;
		this.modulos = modulos;
		this.clase = clase;
		this.entidad = entidad;
		this.id = id;
		this.id_calle = id_calle;
	}

	public String getCalle() {
		return calle;
	}

	public String getNumero() {
		return numero;
	}

	public String getModulos() {
		return modulos;
	}

	public String getClase() {
		return clase;
	}

	public String getEntidad() {
		return entidad;
	}

	public String getId() {
		return id;
	}

	public String getId_calle() {
		return id_calle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, clase, entidad, id, id_calle, modulos, numero);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj!=null && obj instanceof Caseta) {
			Caseta other = (Caseta) obj;
			sonIguales= Objects.equals(calle, other.calle) && Objects.equals(clase, other.clase)
					&& Objects.equals(entidad, other.entidad) && Objects.equals(id, other.id)
					&& Objects.equals(id_calle, other.id_calle) && Objects.equals(modulos, other.modulos)
					&& Objects.equals(numero, other.numero);
		}
		return sonIguales;
		
	}

	@Override
	public String toString() {
		return String.format("Caseta situada en la calle %s con número %s y módulos %s, clase %s ,entidad %s, id %s, y id de la calle %s", 
				this.calle,this.numero,this.modulos,this.clase,this.entidad,this.id,this.id_calle);
	}
	
	public void restarNumero(int num) {
		this.numero=String.valueOf(Integer.valueOf(numero)-num);
	}

	@Override
	public int compareTo(Caseta o) {
		return this.numero.compareTo(o.numero);
	}
}
