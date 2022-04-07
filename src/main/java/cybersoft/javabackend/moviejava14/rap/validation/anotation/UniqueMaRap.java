package cybersoft.javabackend.moviejava14.rap.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.rap.validation.validator.UniqueMaRapValidator;

@Constraint(validatedBy = UniqueMaRapValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMaRap {
	
	String message() default "Mã rạp đã được sử dụng. ";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
