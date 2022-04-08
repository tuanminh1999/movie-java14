package cybersoft.javabackend.moviejava14.loaiGhe.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;
import cybersoft.javabackend.moviejava14.loaiGhe.repository.LoaiGheRepository;
import cybersoft.javabackend.moviejava14.loaiGhe.validation.annotation.UniqueMaLoaiGhe;

public class UniqueMaLoaiGheValidator implements ConstraintValidator<UniqueMaLoaiGhe, String> {

	@Autowired
	private LoaiGheRepository loaiGheRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueMaLoaiGhe uniqueMaLoaiGhe) {
		ConstraintValidator.super.initialize(uniqueMaLoaiGhe);
		this.message = uniqueMaLoaiGhe.message();
	}
	
	@Override
	public boolean isValid(String maLoaiGhe, ConstraintValidatorContext context) {
		Optional<LoaiGhe> loaiGheOpt = loaiGheRepository.findById(maLoaiGhe);
		
		if(!loaiGheOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
