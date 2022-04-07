package cybersoft.javabackend.moviejava14.cumRap.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.cumRap.repository.CumRapRepository;
import cybersoft.javabackend.moviejava14.cumRap.validation.anotation.UniqueTenCumRap;

public class UniqueTenCumRapValidator implements ConstraintValidator<UniqueTenCumRap, String>{

	@Autowired
	private CumRapRepository cumRapRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueTenCumRap uniqueTenCumRap) {
		ConstraintValidator.super.initialize(uniqueTenCumRap);
		this.message = uniqueTenCumRap.message();
	}
	
	@Override
	public boolean isValid(String tenCumRap, ConstraintValidatorContext context) {
		Optional<CumRap> cumRapOpt = cumRapRepository.findByTenCumRap(tenCumRap);
		
		if(!cumRapOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
