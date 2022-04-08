package cybersoft.javabackend.moviejava14.loaiGhe.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.loaiGhe.validation.validator.ExistedMaLoaiGheValidator;

@Constraint(validatedBy = ExistedMaLoaiGheValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistedMaLoaiGhe {
	
	String message() default "Mã loại ghế không tồn tại. ";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
