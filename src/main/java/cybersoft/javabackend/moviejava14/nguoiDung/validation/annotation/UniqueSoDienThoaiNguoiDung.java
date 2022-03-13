package cybersoft.javabackend.moviejava14.nguoiDung.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.nguoiDung.validation.validator.UniqueSoDienThoaiNguoiDungValidator;

@Constraint(validatedBy = UniqueSoDienThoaiNguoiDungValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueSoDienThoaiNguoiDung {
	
	String message() default "Số điện thoại người dùng đã được sử dụng";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
