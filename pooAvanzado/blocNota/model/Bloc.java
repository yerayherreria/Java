package blocNota.model;

import java.util.Arrays;
import java.util.Objects;

import blocNota.exception.BlocException;

public class Bloc {
	private static final int NUMERO_NOTAS_MAXIMA = 15;
	private int numNotas;
	private String nombre;
	private Nota[] notas;
	
	public Bloc(String nombre) {
		super();
		this.nombre = nombre;
		this.notas= new Nota[NUMERO_NOTAS_MAXIMA];
	}
	
	private int buscarNota(int codigo) {
		int posicion = -1;
		for(int i=0; i<NUMERO_NOTAS_MAXIMA && posicion!=-1; i++) {
			if(this.notas!=null && this.notas[i].getCodigo()==codigo) {
				posicion = i;
			}
		}
		return posicion;
	}
	
	private Nota[] quitarNulos() {
		int cont=0;
		for(int i=0; i<notas.length; i++) {
			if(this.notas!=null) {
				cont++;
			}
		}

		Nota[] notaSinNulo= new Nota[cont];
		int acum=0;
		for(int i=0; i<notas.length; i++) {
			if(this.notas!=null) {
				notaSinNulo[acum++]=this.notas[i];
			}
		}
		return notaSinNulo;
	}
	
	public void addNota(String texto) throws BlocException {
		if(numNotas < NUMERO_NOTAS_MAXIMA) {
			this.notas[numNotas] = new Nota(texto);
			numNotas++;
		} else {
			throw new BlocException("Error. No hay espacio.");			
		}
	}

	public String getNota(int codigoNota) {
		String nota="";
		if(codigoNota != -1) {
			nota = String.valueOf(this.notas[buscarNota(codigoNota)]);
		}
		return nota;
	}
	
	public void updateNota(int codigo,String texto) {
		for(int i=0; i<notas.length; i++) {
			if(this.notas[i]!=null && this.notas[i].getCodigo()==codigo) {
				this.notas[i].setTexto(texto);
			}
		}
	}
	
	public void activar(int codigo) {
		for(int i=0; i<notas.length; i++) {
			if(this.notas[i]!=null && this.notas[i].getCodigo()==codigo && this.notas[i] instanceof NotaAlarma) {
				NotaAlarma notaAlarma = ((NotaAlarma)this.notas[i]);
				notaAlarma.activar();
			}
		}
	}
	
	public void desactivar(int codigo) {
		for(int i=0; i<notas.length; i++) {
			if(this.notas[i]!=null && this.notas[i].getCodigo()==codigo && this.notas[i] instanceof NotaAlarma) {
				NotaAlarma notaAlarma = ((NotaAlarma)this.notas[i]);
				notaAlarma.desactivar();
			}
		}
	}

	public static int getNumeroNotasMaxima() {
		return NUMERO_NOTAS_MAXIMA;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "El bloc contiene " + numNotas + " notas ,cuyo nombre es " + nombre + ".";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, numNotas);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales= this == obj && obj == null;
		if (!sonIguales && obj instanceof Bloc) {
			Bloc other = (Bloc) obj;
			sonIguales = Objects.equals(nombre, other.nombre) && Arrays.equals(notas, other.notas) && numNotas == other.numNotas;			
		}
		return sonIguales;
	}
	
	public String ordenaBloc() {
		Nota[] notaSinNulos=quitarNulos();
		Arrays.sort(notaSinNulos);
		return Arrays.toString(notaSinNulos);
	}
	
	
	
}
