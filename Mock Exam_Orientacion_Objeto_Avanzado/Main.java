package mockExam;

import mockExam.excepciones.MemoryStorageException;
import mockExam.excepciones.PublicacionException;
import mockExam.model.MemoryStorage;
import mockExam.model.Publicacion;
import mockExam.model.Tweet;
import mockExam.model.Usuario;
import mockExam.model.Valoraciones;

public class Main {

	public static void main(String[] args) throws PublicacionException, MemoryStorageException {
		System.out.println(Valoraciones.BUENA.getValoracion());
        Publicacion p = new Tweet("curro",new Usuario("yeray","eeee"));
    
        System.out.println(p);
        Usuario u = new Usuario("yeray","tutu");
        MemoryStorage m = new MemoryStorage();
        m.addUsuario("yeray", "ww");
        m.addPublicacion("Curro", "yeray");
        System.out.println(m.mostrarTweets());
        m.mostrarPosts();
	}

}
