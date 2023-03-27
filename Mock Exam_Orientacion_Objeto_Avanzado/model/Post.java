package mockExam.model;

import mockExam.excepciones.PublicacionException;

public class Post extends Publicacion {
	private int numeroLectura;
	private String tema;
	
	public Post(String texto, Usuario usuario ,String tema) throws PublicacionException {
		super(texto, usuario);
		this.tema=tema;
		setTexto(texto);
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if (texto!=null && !texto.isBlank()) {
			this.texto=texto;
		} else {
			throw new PublicacionException();
		}
		
	}
	
	public boolean Valorar(Valoraciones valoracion) {
		this.valoracion=valoracion.getValoracion()*2;
		this.numeroLectura++;
		return true;
	}

	@Override
	public String toString() {
		return "Post.\r\n"
				+ "Publicación: "+ this.texto +"\r\n"
				+ "Realizada por: "+ getLoginUsuario() +"\r\n"
				+ "Valoración: "+ this.valoracion +"\r\n"
				+ "Fecha de publicación: "+ getFechaCreacion();
	}

	public int getNumeroLectura() {
		return numeroLectura;
	}

}
