package cybersoft.javabackend.moviejava14.heThongRap.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.repository.HeThongRapRepository;
import cybersoft.javabackend.moviejava14.heThongRap.validation.anotation.UniqueTenHeThongRap;

public class UniqueTenHeThongRapValidator implements ConstraintValidator<UniqueTenHeThongRap, String>{

	@Autowired
	private HeThongRapRepository heThongRapRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueTenHeThongRap uniqueTenHeThongRap) {
		ConstraintValidator.super.initialize(uniqueTenHeThongRap);
		this.message = uniqueTenHeThongRap.message();
	}
	
	@Override
	public boolean isValid(String tenHeThongRap, ConstraintValidatorContext context) {
		Optional<HeThongRap> heThongRapOpt = heThongRapRepository.findByTenHeThongRap(tenHeThongRap);
		
		if(!heThongRapOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
