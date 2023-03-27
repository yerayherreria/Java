package mockExam.model;

import mockExam.excepciones.PublicacionException;

public class Tweet extends Publicacion {
	private final int NUM_MAX_CARACTERES = 50;
	
	public Tweet(String texto, Usuario usuario) throws PublicacionException {
		super(texto, usuario);
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto!=null && texto.length() < NUM_MAX_CARACTERES) {
			this.texto=texto;
		} else {
			throw new PublicacionException();
		}
	}
	
	public boolean Valorar(Valoraciones valoracion) {
		this.valoracion=valoracion.getValoracion()*2;
		return true;
	}
	
	@Override
	public String toString() {
		return "Tweet.\r\n"
				+ "Publicación: "+ this.texto +"\r\n"
				+ "Realizada por: "+ getLoginUsuario() +"\r\n"
				+ "Valoración: "+ this.valoracion +"\r\n"
				+ "Fecha de publicación: "+ getFechaCreacion();
	}
	
	

}
