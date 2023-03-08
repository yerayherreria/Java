package mockExam.orientacioObjetos.model;

import java.util.Objects;

public class Vino {
	private String nombre;
	private double graduacion;
	
	public Vino(String descripcion) {
		super();
		this.nombre=descripcion;
	}
	public Vino(String descripcion,double graduacion) {
		this(descripcion);
		if (graduacion>=0) {
			this.graduacion=graduacion;	
		}
	}
	public String getNombre() {
		return nombre;
	}
	public double getGraduacion() {
		return graduacion;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj;
		
		if (!sonIguales && obj != null && obj instanceof Vino) {
			Vino other = (Vino) obj;
			sonIguales=Objects.equals(nombre, other.nombre);
		}
		return sonIguales;
	}
}
