package cybersoft.javabackend.moviejava14.loaiNguoiDung.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cybersoft.javabackend.moviejava14.common.ResponseHandler;

@RestControllerAdvice
public class LoaiNguoiDungHandlerException {
	
	@ExceptionHandler(value = {InvalidLoaiNguoiDungException.class})
	public Object handleInvalidLoaiNguoiDungException(InvalidLoaiNguoiDungException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
