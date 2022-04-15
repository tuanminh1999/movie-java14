package cybersoft.javabackend.moviejava14.lichchieu.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.lichchieu.validation.validator.ExistedMaLichChieuValidator;

@Constraint(validatedBy = ExistedMaLichChieuValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistedMaLichChieu {
	String message() default "Mã lịch chiếu không tồn tại";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
