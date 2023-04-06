package empresaIT.exception;

public class EmpresaException extends Exception {

	public EmpresaException() {
		super();
	}

	public EmpresaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmpresaException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmpresaException(String message) {
		super(message);
	}

	public EmpresaException(Throwable cause) {
		super(cause);
	}

}
