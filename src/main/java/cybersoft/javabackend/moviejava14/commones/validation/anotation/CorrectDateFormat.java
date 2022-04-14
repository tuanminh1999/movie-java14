package cybersoft.javabackend.moviejava14.commones.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.commones.validation.validator.CorrectDateFormatValidator;

@Constraint(validatedBy = CorrectDateFormatValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrectDateFormat {
	
	String message() default "Ngày sai định dạng dd/MM/yyyy";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
