package cybersoft.javabackend.moviejava14.cumRap.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.cumRap.validation.validator.UniqueMaCumRapValidator;

@Constraint(validatedBy = UniqueMaCumRapValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMaCumRap {
	
	String message() default "Mã cụm rạp đã được sử dụng. ";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
