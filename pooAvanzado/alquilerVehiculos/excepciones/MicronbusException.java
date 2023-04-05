package alquilerVehiculos.excepciones;

public class MicronbusException extends Exception {

	public MicronbusException() {
	}

	public MicronbusException(String message) {
		super(message);
	}

	public MicronbusException(Throwable cause) {
		super(cause);
	}

	public MicronbusException(String message, Throwable cause) {
		super(message, cause);
	}

	public MicronbusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
