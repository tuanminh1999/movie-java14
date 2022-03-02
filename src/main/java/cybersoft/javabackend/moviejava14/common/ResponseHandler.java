package cybersoft.javabackend.moviejava14.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import cybersoft.javabackend.moviejava14.common.utils.ErrorUtil;

public class ResponseHandler {
	
	
	public static ResponseEntity<Object> getErrorResponse(Object obj, HttpStatus status){
		Object error = null;
		
		if (obj instanceof BindingResult) {
			error = ErrorUtil.solveError((BindingResult)obj);
		} else {
			error = obj;
		}
		
		return new ResponseEntity<Object>(error, status);
	}

}
