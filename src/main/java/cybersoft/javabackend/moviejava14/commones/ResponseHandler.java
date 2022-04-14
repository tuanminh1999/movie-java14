package cybersoft.javabackend.moviejava14.commones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import cybersoft.javabackend.moviejava14.commones.utils.ErrorUtil;

public class ResponseHandler {
	
	public static Object getErrorResponse(Object obj, HttpStatus status){
		Object error = null;
		
		if (obj instanceof BindingResult) {
			error = ErrorUtil.solveError((BindingResult)obj);
		} else {
			error = obj;
		}
		
		return new ResponseEntity<>(error, status);
	}

}
