package cybersoft.javabackend.moviejava14.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;

@RestControllerAdvice
public class GlobalHandlerException {
	
	@ExceptionHandler(value = {InvalidDataException.class})
	public Object handleInvalidLoaiNguoiDungException(InvalidDataException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
}
