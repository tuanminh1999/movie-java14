package cybersoft.javabackend.moviejava14.loaiGhe.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.loaiGhe.validation.annotation.UniqueTenLoaiGhe;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.service.LoaiNguoiDungService;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.UniqueTenLoaiNguoiDung;

public class UniqueTenLoaiGheValidator implements ConstraintValidator<UniqueTenLoaiGhe, String> {

	@Autowired
	private LoaiNguoiDungService loaiNguoiDungService;
	
	private String message;
	
	@Override
	public void initialize(UniqueTenLoaiGhe uniqueTenLoaiGhe) {
		ConstraintValidator.super.initialize(uniqueTenLoaiGhe);
		this.message = uniqueTenLoaiGhe.message();
	}
	
	@Override
	public boolean isValid(String tenLoaiGhe, ConstraintValidatorContext context) {
		Optional<LoaiNguoiDungDTO> roleOpt = loaiNguoiDungService.findByTenLoaiNguoiDung(tenLoaiGhe);
		
		if(roleOpt == null) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}