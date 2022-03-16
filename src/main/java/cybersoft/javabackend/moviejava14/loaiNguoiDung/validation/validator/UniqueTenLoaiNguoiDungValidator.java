package cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.service.LoaiNguoiDungService;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.UniqueTenLoaiNguoiDung;

public class UniqueTenLoaiNguoiDungValidator implements ConstraintValidator<UniqueTenLoaiNguoiDung, String> {

	@Autowired
	private LoaiNguoiDungService loaiNguoiDungService;
	
	private String message;
	
	@Override
	public void initialize(UniqueTenLoaiNguoiDung uniqueTenLoaiNguoiDung) {
		ConstraintValidator.super.initialize(uniqueTenLoaiNguoiDung);
		this.message = uniqueTenLoaiNguoiDung.message();
	}
	
	@Override
	public boolean isValid(String tenLoai, ConstraintValidatorContext context) {
		Optional<LoaiNguoiDungDTO> roleOpt = loaiNguoiDungService.findByTenLoai(tenLoai);
		
		if(roleOpt == null) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
