package cybersoft.javabackend.moviejava14.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cybersoft.javabackend.moviejava14.commones.ResponseHandler;

@RestControllerAdvice
public class SecurityHandlerException {
	
	@ExceptionHandler(value = {MovieIncorrectLoginException.class})
	public Object handleMovieIllegalJwtException(MovieIncorrectLoginException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {MovieIllegalJwtException.class})
	public Object handleMovieIllegalJwtException(MovieIllegalJwtException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
