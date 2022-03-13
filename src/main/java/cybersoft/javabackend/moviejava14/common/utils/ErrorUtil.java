package cybersoft.javabackend.moviejava14.common.utils;

import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

public class ErrorUtil {

	public static Object solveError(BindingResult bindingResult) {

		return bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
		
//		List<String> errorsMessages = new LinkedList<String>();
//		List<ObjectError> errors = bindingResult.getAllErrors();
//		
//		for(ObjectError error : errors) {
//			errorsMessages.add(error.getDefaultMessage());
//		}
//		
//		return errorsMessages;
	}

}
