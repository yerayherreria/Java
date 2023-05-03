package ficheros.inicio;
import java.io.File;

public class Fichero {
	
	private String nombre;
	private String ruta;
	private long tamannio;
	private String permisos;
	private boolean esDirectorio;
	private String ficheroHijos;
	private String directoriosHijos;
	private File file;

	public Fichero(String rutaAbsoluta) {

		file = new File(rutaAbsoluta);
		
		if(!this.file.exists()) {
			file.mkdir();
		}
		
		if(this.file.exists()) {
			this.ruta = file.getPath();
			this.nombre = file.getName();
			this.tamannio = file.length();
			this.permisos = this.file.canWrite() ? "permiso de escritura" : "";
			this.esDirectorio = file.isDirectory();
			this.ficheroHijos = "0";			
			this.directoriosHijos = "0";
		}
		
		if(this.file.listFiles()!=null) {
			for(File hijos : this.file.listFiles()){
				if(hijos.isDirectory()) {
					this.directoriosHijos += hijos.toString() + " ";
				}else {
					this.ficheroHijos += hijos.toString() + " ";
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Fichero [nombre=" + nombre + ", ruta=" + ruta + ", tamannio=" + tamannio + ", permisos=" + permisos
				+ ", esDirectorio=" + esDirectorio + ", ficheroHijos=" + ficheroHijos + ", directoriosHijos="
				+ directoriosHijos + ", file=" + file + "]";
	}


}
