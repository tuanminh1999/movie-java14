package cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.service.LoaiNguoiDungService;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.UniqueMaLoaiNguoiDung;

public class UniqueMaLoaiNguoiDungValidator implements ConstraintValidator<UniqueMaLoaiNguoiDung, String> {

	@Autowired
	private LoaiNguoiDungService loaiNguoiDungService;
	
	private String message;
	
	@Override
	public void initialize(UniqueMaLoaiNguoiDung uniqueMaLoaiNguoiDung) {
		ConstraintValidator.super.initialize(uniqueMaLoaiNguoiDung);
		this.message = uniqueMaLoaiNguoiDung.message();
	}
	
	@Override
	public boolean isValid(String maLoaiNguoiDung, ConstraintValidatorContext context) {
		Optional<LoaiNguoiDungDTO> roleOpt = loaiNguoiDungService.getNguoiDungById(maLoaiNguoiDung);
		
		if(roleOpt == null) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
