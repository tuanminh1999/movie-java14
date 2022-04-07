package cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.repositoty.LoaiNguoiDungRepository;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.UniqueMaLoaiNguoiDung;

public class UniqueMaLoaiNguoiDungValidator implements ConstraintValidator<UniqueMaLoaiNguoiDung, String> {

	@Autowired
	private LoaiNguoiDungRepository loaiNguoiDungRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueMaLoaiNguoiDung uniqueMaLoaiNguoiDung) {
		ConstraintValidator.super.initialize(uniqueMaLoaiNguoiDung);
		this.message = uniqueMaLoaiNguoiDung.message();
	}
	
	@Override
	public boolean isValid(String maLoaiNguoiDung, ConstraintValidatorContext context) {
		Optional<LoaiNguoiDung> loaiNguoiDungOpt = loaiNguoiDungRepository.findById(maLoaiNguoiDung);
		
		if(!loaiNguoiDungOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
