package cybersoft.javabackend.moviejava14.common.utils;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorUtil {

	public static Object solveError(BindingResult bindingResult) {
		List<String> errorsMessages = new LinkedList<String>();
		List<ObjectError> errors = bindingResult.getAllErrors();
		
		for(ObjectError error : errors) {
			errorsMessages.add(error.getDefaultMessage());
		}
		
		return errorsMessages;
	}
	
}
