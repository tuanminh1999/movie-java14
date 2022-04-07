package cybersoft.javabackend.moviejava14.cumRap.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.cumRap.repository.CumRapRepository;
import cybersoft.javabackend.moviejava14.cumRap.validation.anotation.UniqueMaCumRap;

public class UniqueMaCumRapValidator implements ConstraintValidator<UniqueMaCumRap, String>{

	@Autowired
	private CumRapRepository cumRapRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueMaCumRap uniqueMaCumRap) {
		ConstraintValidator.super.initialize(uniqueMaCumRap);
		this.message = uniqueMaCumRap.message();
	}
	
	@Override
	public boolean isValid(String maCumRap, ConstraintValidatorContext context) {
		Optional<CumRap> cumRapOpt = cumRapRepository.findById(maCumRap);
		
		if(!cumRapOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
