package alquilerVehiculos.excepciones;

public class FurgonetaException extends Exception {

	public FurgonetaException() {
	}

	public FurgonetaException(String message) {
		super(message);
	}

	public FurgonetaException(Throwable cause) {
		super(cause);
	}

	public FurgonetaException(String message, Throwable cause) {
		super(message, cause);
	}

	public FurgonetaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
