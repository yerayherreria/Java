package mockExam.model;

import mockExam.excepciones.MemoryStorageException;
import mockExam.excepciones.PublicacionException;

public class MemoryStorage {
	private final static int NUM_MAX_USUARIOS=15;
	private final static int NUM_MAX_PUBLICACIONES=50;
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	
	Usuario[] usuario = new Usuario[NUM_MAX_USUARIOS];
	Publicacion[] publicacion = new Publicacion[NUM_MAX_PUBLICACIONES];
	
	public MemoryStorage() {};
	
	private int posicionUsuario(String login) {
		boolean encontrado=false;
		int posicion = -1;
		
		for (int i = 0 ; i < NUM_MAX_USUARIOS && !encontrado; i++) {
			if (this.usuario[i].getLogin().equals(login) && this.usuario[i]!=null) {
				encontrado=true;
				posicion=i;
			}
		}
		return posicion;
	}
	
	public void addUsuario(String login,String pass) throws MemoryStorageException {
		if(numUsuariosActuales < NUM_MAX_USUARIOS) {
			this.usuario[numUsuariosActuales]= new Usuario(login, pass);
			numUsuariosActuales++;			
		} else {
			throw new MemoryStorageException();
		}
	}
	
	public void addPublicacion(String texto, String login) throws PublicacionException  {
		this.publicacion[numPublicacionesActuales%NUM_MAX_PUBLICACIONES]= new Tweet(texto,this.usuario[posicionUsuario(login)]);
		numPublicacionesActuales++;
	}
	
	public void addPublicacion(String texto, String login ,String tema) throws PublicacionException  {
		this.publicacion[numPublicacionesActuales%NUM_MAX_PUBLICACIONES]= new Post(texto,this.usuario[posicionUsuario(login)],tema);
		numPublicacionesActuales++;
	}
	
	public void addPublicacion(String texto, String login ,int numeroEstrellas) throws PublicacionException  {
		this.publicacion[numPublicacionesActuales%NUM_MAX_PUBLICACIONES]= new Recomendacion(texto,this.usuario[posicionUsuario(login)],numeroEstrellas);
		numPublicacionesActuales++;
	}
	
	public String mostrarListaPublicaciones() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<NUM_MAX_PUBLICACIONES; i++) {
			if(this.publicacion[i] != null) {
				sb.append(this.publicacion[i]).append("\n");
			}
		}
		return sb.toString();
	}
	public String mostrarTweets() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<NUM_MAX_PUBLICACIONES; i++) {
			if(this.publicacion[i] != null && this.publicacion[i] instanceof Tweet) {
				sb.append(this.publicacion[i]).append("\n");
			}
		}
		return sb.toString();
	}
	public String mostrarPosts() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<NUM_MAX_PUBLICACIONES; i++) {
			if(this.publicacion[i] != null && this.publicacion[i] instanceof Post) {
				sb.append(this.publicacion[i]).append("\n");
			}
		}
		return sb.toString();
	}
	public String mostrarRecomendacion() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<NUM_MAX_PUBLICACIONES; i++) {
			if(this.publicacion[i] != null && this.publicacion[i] instanceof Recomendacion) {
				sb.append(this.publicacion[i]).append("\n");
			}
		}
		return sb.toString();
	}
}
