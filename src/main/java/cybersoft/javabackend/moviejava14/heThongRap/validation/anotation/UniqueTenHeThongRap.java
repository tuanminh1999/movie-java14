package cybersoft.javabackend.moviejava14.heThongRap.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.heThongRap.validation.validator.UniqueTenHeThongRapValidator;

@Constraint(validatedBy = UniqueTenHeThongRapValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueTenHeThongRap {
	
	String message() default "Tên hệ thống rạp đã được sử dụng. ";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
