package blocNota.model;

import java.time.LocalDateTime;

import blocNota.exception.BlocException;
import blocNota.exception.NotaAlarmaException;

public class NotaAlarma extends Nota implements Activable {

	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO=5;
	private int minutosRepetir;
	private boolean activado;
	
	public NotaAlarma(String texto, LocalDateTime fechaAlarma, boolean activado) throws NotaAlarmaException {
		super(texto);
		if (texto!=null && fechaAlarma!=null) {
			this.fechaAlarma=fechaAlarma;
			this.activado=activado;
			this.minutosRepetir=MINUTOS_REPETIR_POR_DEFECTO;
		} else {
			throw new NotaAlarmaException("Error.Valores no válidos.");
		}
	}
	
	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int minutos) throws NotaAlarmaException {
		super(texto);
		if (texto!=null && fechaAlarma!=null && minutos>0) {
			this.fechaAlarma=fechaAlarma;
			this.minutosRepetir=minutos;
		} else {
			throw new NotaAlarmaException("Error.Valores no válidos.");
		}
	}

	private void setFechaAlarma(LocalDateTime fechaAlarma) {
		this.fechaAlarma = fechaAlarma;
	}

	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}

	@Override
	public void activar() {
		this.activado=true;
	}

	@Override
	public void desactivar() {
		this.activado=false;
	}
	
	public boolean isActivado() {
		return this.activado;
	}

	@Override
	public String toString() {
		return "La nota alarma tiene fecha" + fechaAlarma + ", la cual se repite " + minutosRepetir + " minutos, y su estado es "
				+ activado;
	}
	

}
