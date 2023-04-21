package collections.boletin1.ejercicio4.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class PaginaWeb {
	
	private String url;
	private LocalDateTime fechayhora;
	
	public PaginaWeb(String url, LocalDateTime fechayhora) {
		super();
		this.url = url;
		this.fechayhora = fechayhora;
	}

	public String getUrl() {
		return url;
	}

	public LocalDateTime getFechayhora() {
		return fechayhora;
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales= this==obj;
		if(!sonIguales && obj!=null && obj instanceof PaginaWeb) {
			PaginaWeb other = (PaginaWeb) obj;
			sonIguales = Objects.equals(fechayhora, other.fechayhora) && Objects.equals(url, other.url);			
		}
		return sonIguales;
	}

	@Override
	public String toString() {
		return "La pagina web " + url + " es visitada el " + fechayhora + ".";
	}
	
}
