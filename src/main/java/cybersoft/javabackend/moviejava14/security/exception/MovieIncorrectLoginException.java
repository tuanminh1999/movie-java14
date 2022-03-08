package cybersoft.javabackend.moviejava14.security.exception;

public class MovieIncorrectLoginException extends RuntimeException{

	private static final long serialVersionUID = -1045601268219625591L;

	public MovieIncorrectLoginException(String message) {
		super(message);
	}
	
}
