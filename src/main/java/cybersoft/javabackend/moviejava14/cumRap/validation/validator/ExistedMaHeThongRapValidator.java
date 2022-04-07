package cybersoft.javabackend.moviejava14.cumRap.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.cumRap.validation.anotation.ExistedMaHeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.repository.HeThongRapRepository;

public class ExistedMaHeThongRapValidator implements ConstraintValidator<ExistedMaHeThongRap, String>{
	
	@Autowired
	private HeThongRapRepository heThongRapRepository;
	
	private String message;
	
	@Override
	public void initialize(ExistedMaHeThongRap existedMaHeThongRap) {
		ConstraintValidator.super.initialize(existedMaHeThongRap);
		this.message = existedMaHeThongRap.message();
	}

	@Override
	public boolean isValid(String maHeThongRap, ConstraintValidatorContext context) {
		Optional<HeThongRap> heThongRapOpt = heThongRapRepository.findById(maHeThongRap);
		
		if(heThongRapOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
