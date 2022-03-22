package cybersoft.javabackend.moviejava14.phịm.validation.validator;

import java.sql.Timestamp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.moviejava14.common.utils.DateFormatter;
import cybersoft.javabackend.moviejava14.phịm.validation.anotation.CorrectDateFormat;

public class CorrectDateFormatValidator implements ConstraintValidator<CorrectDateFormat, String>{

	private String message;
	
	@Override
	public void initialize(CorrectDateFormat correctDateFormat) {
		ConstraintValidator.super.initialize(correctDateFormat);
		this.message = correctDateFormat.message();
	}
	
	@Override
	public boolean isValid(String date, ConstraintValidatorContext context) {
		Timestamp dateTimestamp = DateFormatter.convertStringToTimestamp(date);
		
		if(dateTimestamp != null) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
	
	return false;
	}

}
