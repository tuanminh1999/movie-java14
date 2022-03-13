package cybersoft.javabackend.moviejava14.nguoiDung.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.nguoiDung.validation.validator.UniqueTaiKhoanNguoiDungValidator;

@Constraint(validatedBy = UniqueTaiKhoanNguoiDungValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueTaiKhoanNguoiDung {
	String message() default "Tài khoản người dùng đã được sử dụng";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
