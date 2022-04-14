package cybersoft.javabackend.moviejava14.commones.exeption;

public class InvalidDataException extends RuntimeException {

private static final long serialVersionUID = 3574445718032242736L;
	
	public InvalidDataException() {
		super();
	}

	public InvalidDataException(String message) {
		super(message);
	}
	
}
