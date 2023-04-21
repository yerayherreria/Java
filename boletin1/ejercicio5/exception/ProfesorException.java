package collections.boletin1.ejercicio5.exception;

public class ProfesorException extends Exception {
	public ProfesorException() {
	}

	public ProfesorException(String message) {
		super(message);
	}

	public ProfesorException(Throwable cause) {
		super(cause);
	}

	public ProfesorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProfesorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
