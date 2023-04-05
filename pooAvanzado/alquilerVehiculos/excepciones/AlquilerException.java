package alquilerVehiculos.excepciones;

public class AlquilerException extends Exception {

	public AlquilerException() {
	}

	public AlquilerException(String message) {
		super(message);
	}

	public AlquilerException(Throwable cause) {
		super(cause);
	}

	public AlquilerException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlquilerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
