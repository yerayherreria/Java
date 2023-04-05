package blocNota;

import java.time.LocalDateTime;

import blocNota.exception.BlocException;
import blocNota.exception.NotaAlarmaException;
import blocNota.model.Bloc;
import blocNota.model.Nota;
import blocNota.model.NotaAlarma;

public class Main {

	public static void main(String[] args) {
		Nota nota1 = new Nota("Mañana examen de programacion");
		
		Bloc bloc = new Bloc("Curro");
		try {
			bloc.addNota("Mañana examen de programacion");
			bloc.addNota("Quedan dos dias");
		} catch (BlocException e) {
			e.printStackTrace();
		}
		System.out.println(bloc);
		
		NotaAlarma notaAlarma;
		try {
			notaAlarma = new NotaAlarma("Quedan dos dias",LocalDateTime.now(),true);
			notaAlarma.activar();
			System.out.println(notaAlarma);
			notaAlarma.desactivar();
			System.out.println("------");
			System.out.println(notaAlarma);
		} catch (NotaAlarmaException e) {
			e.printStackTrace();
		}
		
	}

}
