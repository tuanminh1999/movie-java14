package cybersoft.javabackend.moviejava14.phịm.validation.anotation;

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
public @interface ExistedMaPhim {
	String message() default "Mã phim không tồn tại";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
