package mockExam.excepciones;

public class PublicacionException extends Exception {
	private final static String MENSAJE="Caractares no validos.";

	public PublicacionException() {
		super(MENSAJE);
	}

	public PublicacionException(String message) {
		super(message);
	}

	public PublicacionException(Throwable cause) {
		super(cause);
	}

	public PublicacionException(String message, Throwable cause) {
		super(message, cause);
	}

	public PublicacionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
