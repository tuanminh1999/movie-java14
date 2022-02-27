package cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.validator.UniqueTenLoaiNguoiDungValidator;

@Constraint(validatedBy = UniqueTenLoaiNguoiDungValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueTenLoaiNguoiDung {
	
	String message() default "Tên loại người dùng đã được sử dụng";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
