package cybersoft.javabackend.moviejava14.commones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cybersoft.javabackend.moviejava14.commones.exeption.DateFormatException;
import cybersoft.javabackend.moviejava14.commones.exeption.ExistedDataException;
import cybersoft.javabackend.moviejava14.commones.exeption.InvalidDataException;

@RestControllerAdvice
public class GlobalHandlerException {
	
	@ExceptionHandler(value = {InvalidDataException.class})
	public Object handleInvalidDataDungException(InvalidDataException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {ExistedDataException.class})
	public Object handleExistedDataException(ExistedDataException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {DateFormatException.class})
	public Object handleDateFormatExceptionException(DateFormatException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
