package cybersoft.javabackend.moviejava14.common.validation.validator;

import java.sql.Timestamp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.moviejava14.common.utils.DateFormatter;
import cybersoft.javabackend.moviejava14.common.validation.anotation.CorrectDateAndTimeFormat;

public class CorrectDateAndTimeFormatValidator implements ConstraintValidator<CorrectDateAndTimeFormat, String>{

	private String message;
	
	@Override
	public void initialize(CorrectDateAndTimeFormat correctDateAndTimeFormat) {
		ConstraintValidator.super.initialize(correctDateAndTimeFormat);
		this.message = correctDateAndTimeFormat.message();
	}
	
	@Override
	public boolean isValid(String date, ConstraintValidatorContext context) {
		Timestamp dateTimestamp = DateFormatter.convertStringToDateAndTime(date);
		
		if(dateTimestamp != null) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
	
	return false;
	}

}
