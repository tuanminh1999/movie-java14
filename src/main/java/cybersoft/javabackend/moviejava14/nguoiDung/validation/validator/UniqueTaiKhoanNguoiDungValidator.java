package cybersoft.javabackend.moviejava14.nguoiDung.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.repository.NguoiDungRepository;
import cybersoft.javabackend.moviejava14.nguoiDung.validation.annotation.UniqueTaiKhoanNguoiDung;

public class UniqueTaiKhoanNguoiDungValidator implements ConstraintValidator<UniqueTaiKhoanNguoiDung, String> {
	
	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueTaiKhoanNguoiDung uniqueTaiKhoanNguoiDung) {
		ConstraintValidator.super.initialize(uniqueTaiKhoanNguoiDung);
		this.message = uniqueTaiKhoanNguoiDung.message();
	}
	
	@Override
	public boolean isValid(String taiKhoan, ConstraintValidatorContext context) {
		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByTaiKhoan(taiKhoan);
		
		if(!nguoiDungOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}
}
