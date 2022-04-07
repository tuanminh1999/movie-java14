package cybersoft.javabackend.moviejava14.heThongRap.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.repository.HeThongRapRepository;
import cybersoft.javabackend.moviejava14.heThongRap.validation.anotation.UniqueBiDanhHeThongRap;

public class UniqueBiDanhHeThongRapValidator implements ConstraintValidator<UniqueBiDanhHeThongRap, String>{

	@Autowired
	private HeThongRapRepository heThongRapRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueBiDanhHeThongRap uniqueBiDanhHeThongRap) {
		ConstraintValidator.super.initialize(uniqueBiDanhHeThongRap);
		this.message = uniqueBiDanhHeThongRap.message();
	}
	
	@Override
	public boolean isValid(String biDanh, ConstraintValidatorContext context) {
		Optional<HeThongRap> heThongRapOpt = heThongRapRepository.findByBiDanh(biDanh);
		
		if(!heThongRapOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
