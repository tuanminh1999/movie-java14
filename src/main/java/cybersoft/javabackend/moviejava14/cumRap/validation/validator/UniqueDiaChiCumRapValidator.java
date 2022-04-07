package cybersoft.javabackend.moviejava14.cumRap.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.cumRap.repository.CumRapRepository;
import cybersoft.javabackend.moviejava14.cumRap.validation.anotation.UniqueDiaChiCumRap;

public class UniqueDiaChiCumRapValidator implements ConstraintValidator<UniqueDiaChiCumRap, String>{

	@Autowired
	private CumRapRepository cumRapRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueDiaChiCumRap uniqueDiaChiCumRap) {
		ConstraintValidator.super.initialize(uniqueDiaChiCumRap);
		this.message = uniqueDiaChiCumRap.message();
	}
	
	@Override
	public boolean isValid(String diaChi, ConstraintValidatorContext context) {
		Optional<CumRap> cumRapOpt = cumRapRepository.findByDiaChi(diaChi);
		
		if(!cumRapOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
