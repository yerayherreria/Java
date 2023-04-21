package collections.boletin1.ejercicio7.exception;

public class AlmacenException extends Exception {

	public AlmacenException() {
	}

	public AlmacenException(String message) {
		super(message);
	}

	public AlmacenException(Throwable cause) {
		super(cause);
	}

	public AlmacenException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlmacenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
