package cybersoft.javabackend.moviejava14.ghe.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.ghe.validation.validator.ExistedMaGheValidator;

@Constraint(validatedBy = ExistedMaGheValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistedMaGhe {
	
	String message() default "Mã ghế không tồn tại. ";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
