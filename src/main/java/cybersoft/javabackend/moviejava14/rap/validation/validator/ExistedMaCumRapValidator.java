package cybersoft.javabackend.moviejava14.rap.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.cumRap.repository.CumRapRepository;
import cybersoft.javabackend.moviejava14.rap.validation.anotation.ExistedMaCumRap;

public class ExistedMaCumRapValidator implements ConstraintValidator<ExistedMaCumRap, String>{
	
	@Autowired
	private CumRapRepository cumRapRepository;
	
	private String message;
	
	@Override
	public void initialize(ExistedMaCumRap existedMaCumRap) {
		ConstraintValidator.super.initialize(existedMaCumRap);
		this.message = existedMaCumRap.message();
	}

	@Override
	public boolean isValid(String maCumRap, ConstraintValidatorContext context) {
		Optional<CumRap> cumRapOpt = cumRapRepository.findById(maCumRap);
		
		if(cumRapOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
