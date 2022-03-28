package cybersoft.javabackend.moviejava14.lichchieu.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.lichchieu.validation.validator.ExistedMaRapValidator;

@Constraint(validatedBy = ExistedMaRapValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistedMaRap {
	String message() default "Mã rạp không tồn tại";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
