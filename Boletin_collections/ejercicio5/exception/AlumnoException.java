package collections.boletin1.ejercicio5.exception;

public class AlumnoException extends Exception {

	public AlumnoException() {
	}

	public AlumnoException(String message) {
		super(message);
	}

	public AlumnoException(Throwable cause) {
		super(cause);
	}

	public AlumnoException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlumnoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
