package cybersoft.javabackend.moviejava14.cumRap.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.cumRap.validation.validator.UniqueDiaChiCumRapValidator;

@Constraint(validatedBy = UniqueDiaChiCumRapValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueDiaChiCumRap {
	
	String message() default "Địa chỉ cụm rạp đã được sử dụng. ";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
