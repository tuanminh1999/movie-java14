package cybersoft.javabackend.moviejava14.common.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.common.validation.validator.CorrectDateAndTimeFormatValidator;

@Constraint(validatedBy = CorrectDateAndTimeFormatValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrectDateAndTimeFormat {
	
	String message() default "Ngày sai định dạng dd/MM/yyyy hh:mm:ss";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
