package cybersoft.javabackend.moviejava14.security.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MovieIncorrectLoginException extends UsernameNotFoundException{

	private static final long serialVersionUID = -1045601268219625591L;
	

	public MovieIncorrectLoginException(String message) {
		super(message);
	}
	
}
