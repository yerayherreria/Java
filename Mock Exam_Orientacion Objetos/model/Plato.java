package mockExam.orientacioObjetos.model;

import java.util.Objects;

public class Plato {
	
	private String nombre;
	private double precio;
	private static double iva=0.21;
	private Vino vinoRecomendado;
	
	
	public Plato(String nombre) {
		super();
		this.nombre=nombre;
	}
	public Plato(String nombre,double precio) {
		this(nombre);
		if (precio>0) {
			this.precio=precio;
		}
	}
	
	public static double getIva() {
		return iva;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecioBase() {
		return precio;
	}
	public double getPrecioVentaPublico() {
		return this.precio+ this.precio*iva;
	}
	public String getVinoRecomendado() {
		String descripcion = "No hay recomendaciones.";
		if (vinoRecomendado!=null) {
			descripcion = vinoRecomendado.toString();
		}
		return descripcion;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void incrementarPrecio(double incremento) {
		this.precio+=incremento;
	}
	public void setVinoRecomendado(Vino vino) {
		this.vinoRecomendado = vino;
	}
	public void setVinoRecomendado(String vino1, double graduacion) {
		Vino vino = new Vino(vino1,graduacion);
	}
	public double getGradosVinoRecomendado() {
		double resultado=0.0;
		if (this.vinoRecomendado!=null) {
			resultado=this.vinoRecomendado.getGraduacion();
		}
		return resultado;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj;
		
		if (!sonIguales && obj == null && obj instanceof Plato) {
			Plato other = (Plato) obj;
			sonIguales = Objects.equals(nombre, other.nombre);
		}
		return sonIguales;
	}
	@Override
	public String toString() {
		return "El nombre del plato es "+ nombre +", el precio sin iva es "+ precio +", el precio venta público es "+getPrecioVentaPublico()+", y el nombre y la graduación del vino recomendado son "+getVinoRecomendado()+".";
	}
}
