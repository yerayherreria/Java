package mockExam.model;

import mockExam.excepciones.PublicacionException;

public class Recomendacion extends Publicacion {
	
	private int numeroEstrellas;
	private final int NUM_MAX_CARACTERES = 200;
	private final int NUM_MIN_CARACTERES = 100;
	
	public Recomendacion(String texto, Usuario usuario ,int numeroEstrellas) throws PublicacionException {
		super(texto, usuario);
		if (numeroEstrellas>=1 && numeroEstrellas<=5) {
			this.numeroEstrellas=numeroEstrellas;
		}	
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if (texto!=null && texto.length() > NUM_MIN_CARACTERES && texto.length() < NUM_MAX_CARACTERES) {
			this.texto=texto;
		} else {
			throw new PublicacionException();
		}
	}
	
	@Override
	public String toString() {
		return "Recomendación.\r\n"
				+ "Publicación: "+ this.texto +"\r\n"
				+ "Realizada por: "+ getLoginUsuario() +"\r\n"
				+ "Valoración: "+ this.valoracion +"\r\n"
				+ "Fecha de publicación: "+ getFechaCreacion() +"\r\n"
				+ "Número de estrellas: "+ this.numeroEstrellas;
	}
	
	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}

}
