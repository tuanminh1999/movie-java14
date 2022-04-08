package cybersoft.javabackend.moviejava14.nguoiDung.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.repository.NguoiDungRepository;
import cybersoft.javabackend.moviejava14.nguoiDung.validation.annotation.ExistedTaiKhoanNguoiDung;

public class ExistedTaiKhoanNguoiDungValidator implements ConstraintValidator<ExistedTaiKhoanNguoiDung, String>{
	
	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	private String message;
	
	@Override
	public void initialize(ExistedTaiKhoanNguoiDung existedTaiKhoanNguoiDung) {
		ConstraintValidator.super.initialize(existedTaiKhoanNguoiDung);
		this.message = existedTaiKhoanNguoiDung.message();
	}

	@Override
	public boolean isValid(String taiKhoanNguoiDung, ConstraintValidatorContext context) {
		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByTaiKhoan(taiKhoanNguoiDung);
		
		if(nguoiDungOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
