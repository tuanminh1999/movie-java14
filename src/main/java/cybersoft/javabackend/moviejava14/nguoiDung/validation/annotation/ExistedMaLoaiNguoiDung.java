package cybersoft.javabackend.moviejava14.nguoiDung.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.moviejava14.nguoiDung.validation.validator.ExistedMaLoaiNguoiDungValidator;

@Constraint(validatedBy = ExistedMaLoaiNguoiDungValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistedMaLoaiNguoiDung {
	String message() default "Mã loại người dùng không tồn tại. ";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
