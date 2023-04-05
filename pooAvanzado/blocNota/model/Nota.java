package blocNota.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota> {
		private static int codigoSiguiente;
		private int codigo;
		private String texto;
		private LocalDateTime fechaCreacion;
		private LocalDateTime fechaModificacion;
		
		public Nota(String texto) {
			super();
			this.codigo = codigoSiguiente++;
			this.texto = texto;
			this.fechaCreacion = LocalDateTime.now();
		}

		public String getTexto() {
			return texto;
		}

		public void setTexto(String texto) {
			this.texto = texto;
			this.fechaModificacion=LocalDateTime.now();
		}

		public int getCodigo() {
			return codigo;
		}

		public LocalDateTime getFechaCreacion() {
			return fechaCreacion;
		}

		public LocalDateTime getFechaModificacion() {
			return fechaModificacion;
		}
		
		public boolean isModificado() {
			return this.fechaModificacion!=null;
		}
		
		public boolean isEmpty() {
			return this.texto.isEmpty();
		}
		
		public boolean isCreadoAnterior(Nota nota) {
			return this.fechaCreacion.isBefore(nota.fechaCreacion);
		}
		
		public boolean isModificado(Nota nota) {
			return this.fechaModificacion.isBefore(nota.fechaModificacion);
		}

		@Override
		public int hashCode() {
			return Objects.hash(fechaCreacion, texto);
		}

		@Override
		public boolean equals(Object obj) {
			boolean sonIguales = this == obj && obj == null;
			if (!sonIguales && obj instanceof Nota) {
				Nota other = (Nota) obj;
				sonIguales =  Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(texto, other.texto);
			}
			return sonIguales;
		}

		@Override
		public String toString() {
			return "Nota con codigo " + codigo + ", texto " + texto + " , fecha de creacion " + fechaCreacion
					+ "y fecha de modificacion " + fechaModificacion;
		}

		@Override
		public int compareTo(Nota o) {
			return o.getTexto().compareTo(this.texto);
		}
		
}
