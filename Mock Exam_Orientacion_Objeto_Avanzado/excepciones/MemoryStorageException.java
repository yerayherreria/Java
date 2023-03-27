package mockExam.excepciones;

public class MemoryStorageException extends Exception {
	private final static String MENSAJE="Capacidad llena.";
	
	public MemoryStorageException() {
		super(MENSAJE);
	}

	public MemoryStorageException(String message) {
		super(message);
	}

	public MemoryStorageException(Throwable cause) {
		super(cause);
	}

	public MemoryStorageException(String message, Throwable cause) {
		super(message, cause);
	}

	public MemoryStorageException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
