package cybersoft.javabackend.moviejava14.rap.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import cybersoft.javabackend.moviejava14.rap.repository.RapRepository;
import cybersoft.javabackend.moviejava14.rap.validation.anotation.UniqueMaRap;

public class UniqueMaRapValidator implements ConstraintValidator<UniqueMaRap, String>{

	@Autowired
	private RapRepository rapRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueMaRap uniqueMaRap) {
		ConstraintValidator.super.initialize(uniqueMaRap);
		this.message = uniqueMaRap.message();
	}
	
	@Override
	public boolean isValid(String maRap, ConstraintValidatorContext context) {
		Optional<Rap> rapOpt = rapRepository.findById(maRap);
		
		if(!rapOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
