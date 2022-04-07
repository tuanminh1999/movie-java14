package cybersoft.javabackend.moviejava14.heThongRap.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.repository.HeThongRapRepository;
import cybersoft.javabackend.moviejava14.heThongRap.validation.anotation.UniqueMaHeThongRap;

public class UniqueMaHeThongRapValidator implements ConstraintValidator<UniqueMaHeThongRap, String>{

	@Autowired
	private HeThongRapRepository heThongRapRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueMaHeThongRap uniqueMaHeThongRap) {
		ConstraintValidator.super.initialize(uniqueMaHeThongRap);
		this.message = uniqueMaHeThongRap.message();
	}
	
	@Override
	public boolean isValid(String maHeThongRap, ConstraintValidatorContext context) {
		Optional<HeThongRap> heThongRapOpt = heThongRapRepository.findByMaHeThongRap(maHeThongRap);
		
		if(!heThongRapOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
