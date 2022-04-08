package cybersoft.javabackend.moviejava14.ghe.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import cybersoft.javabackend.moviejava14.ghe.repository.GheRepository;
import cybersoft.javabackend.moviejava14.ghe.validation.anotation.ExistedMaGhe;

public class ExistedMaGheValidator implements ConstraintValidator<ExistedMaGhe, Integer>{
	
	@Autowired
	private GheRepository gheRepository;
	
	private String message;
	
	@Override
	public void initialize(ExistedMaGhe existedMaGhe) {
		ConstraintValidator.super.initialize(existedMaGhe);
		this.message = existedMaGhe.message();
	}

	@Override
	public boolean isValid(Integer maGhe, ConstraintValidatorContext context) {
		Optional<Ghe> gheOpt = gheRepository.findById(maGhe);
		
		if(gheOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
