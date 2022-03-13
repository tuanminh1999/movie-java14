package cybersoft.javabackend.moviejava14.nguoiDung.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.service.NguoiDungService;
import cybersoft.javabackend.moviejava14.nguoiDung.validation.annotation.UniqueSoDienThoaiNguoiDung;

public class UniqueSoDienThoaiNguoiDungValidator implements ConstraintValidator<UniqueSoDienThoaiNguoiDung, String>{

	@Autowired
	private NguoiDungService nguoiDungService;
	
	private String message;
	
	@Override
	public void initialize(UniqueSoDienThoaiNguoiDung uniqueSoDienThoaiNguoiDung) {
		ConstraintValidator.super.initialize(uniqueSoDienThoaiNguoiDung);
		this.message = uniqueSoDienThoaiNguoiDung.message();
	}
	
	@Override
	public boolean isValid(String soDienThoaiNguoiDung, ConstraintValidatorContext context) {
		Optional<NguoiDungDTO> nguoiDungOpt = nguoiDungService.getNguoiDungBySoDt(soDienThoaiNguoiDung);
		
		if(nguoiDungOpt == null) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
