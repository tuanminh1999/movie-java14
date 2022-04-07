package cybersoft.javabackend.moviejava14.heThongRap.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.heThongRap.validation.validator.UniqueMaHeThongRapValidator;

@Constraint(validatedBy = UniqueMaHeThongRapValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMaHeThongRap {
	
	String message() default "Mã hệ thống rạp đã được sử dụng. ";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}
