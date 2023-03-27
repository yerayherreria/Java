package mockExam.model;

import java.time.LocalDateTime;
import java.util.Objects;

import mockExam.excepciones.PublicacionException;

public abstract class Publicacion implements Valorable,Comparable<Publicacion>{
	protected String texto;
	protected LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo;
	private static int codigoSiguiente;
	private Usuario usuario;
	
	public Publicacion(String texto, Usuario usuario) throws PublicacionException {
		super();
		this.fechaCreacion = LocalDateTime.now();
		this.codigoSiguiente ++;
		this.usuario = usuario;
		setTexto(texto);
	}
	
	protected String getTexto() {
		return texto;
	}
	
	protected abstract void setTexto(String texto) throws PublicacionException;
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoSiguiente, fechaCreacion, texto, usuario, valoracion);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj;
		
		if (!sonIguales && obj != null && obj instanceof Publicacion) {
			Publicacion other = (Publicacion) obj;
			sonIguales= codigoSiguiente == other.codigoSiguiente && Objects.equals(fechaCreacion, other.fechaCreacion)
					&& Objects.equals(texto, other.texto) && Objects.equals(usuario, other.usuario)
					&& valoracion == other.valoracion;			
		}	
		return sonIguales;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public int getValoracion() {
		return valoracion;
	}
	
	public boolean Valorar(Valoraciones valoracion) {
		this.valoracion=valoracion.getValoracion();
		return true;
	}

	public static int getCodigo() {
		return codigoSiguiente;
	}
	
	public String getLoginUsuario() {
		return usuario.getLogin();
	}

	@Override
	public String toString() {
		return "Publicación: "+ texto +"\r\n"
				+ "Realizada por: "+ getLoginUsuario() +"\r\n"
				+ "Valoración: "+ valoracion +"\r\n"
				+ "Fecha de publicación: "+ fechaCreacion;
	}
	
	public int compareTo(Publicacion p) {
		return this.fechaCreacion.compareTo(p.getFechaCreacion());
	}
	
	public boolean isAnterior(Publicacion pu) {
		return compareTo(pu) > 0;
	}
}
