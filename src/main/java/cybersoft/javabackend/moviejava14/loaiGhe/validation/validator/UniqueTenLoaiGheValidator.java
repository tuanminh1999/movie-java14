package cybersoft.javabackend.moviejava14.loaiGhe.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;
import cybersoft.javabackend.moviejava14.loaiGhe.repository.LoaiGheRepository;
import cybersoft.javabackend.moviejava14.loaiGhe.validation.annotation.UniqueTenLoaiGhe;

public class UniqueTenLoaiGheValidator implements ConstraintValidator<UniqueTenLoaiGhe, String> {

	@Autowired
	private LoaiGheRepository loaiGheRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueTenLoaiGhe uniqueTenLoaiGhe) {
		ConstraintValidator.super.initialize(uniqueTenLoaiGhe);
		this.message = uniqueTenLoaiGhe.message();
	}
	
	@Override
	public boolean isValid(String tenLoaiGhe, ConstraintValidatorContext context) {
		Optional<LoaiGhe> loaiGheOpt = loaiGheRepository.findByTenLoaiGhe(tenLoaiGhe);
		
		if(!loaiGheOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
