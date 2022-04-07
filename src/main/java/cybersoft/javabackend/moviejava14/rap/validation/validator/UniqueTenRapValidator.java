package cybersoft.javabackend.moviejava14.rap.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import cybersoft.javabackend.moviejava14.rap.repository.RapRepository;
import cybersoft.javabackend.moviejava14.rap.validation.anotation.UniqueTenRap;

public class UniqueTenRapValidator implements ConstraintValidator<UniqueTenRap, String>{

	@Autowired
	private RapRepository rapRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueTenRap uniqueTenRap) {
		ConstraintValidator.super.initialize(uniqueTenRap);
		this.message = uniqueTenRap.message();
	}
	
	@Override
	public boolean isValid(String tenRap, ConstraintValidatorContext context) {
		Optional<Rap> rapOpt = rapRepository.findByTenRap(tenRap);
		
		if(!rapOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
