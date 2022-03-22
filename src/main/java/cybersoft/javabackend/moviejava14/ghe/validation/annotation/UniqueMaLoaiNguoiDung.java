package cybersoft.javabackend.moviejava14.ghe.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.validator.UniqueMaLoaiNguoiDungValidator;

@Constraint(validatedBy = UniqueMaLoaiNguoiDungValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMaLoaiNguoiDung {
	
	String message() default "Mã loại người dùng đã được sử dụng";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
