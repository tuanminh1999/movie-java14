package cybersoft.javabackend.moviejava14.security.exception;

import io.jsonwebtoken.JwtException;

public class MovieIllegalJwtException extends JwtException{

	private static final long serialVersionUID = 8105942879951389178L;

	public MovieIllegalJwtException(String message) {
		super(message);
	}
	
}
