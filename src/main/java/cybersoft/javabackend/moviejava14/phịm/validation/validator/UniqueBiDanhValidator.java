package cybersoft.javabackend.moviejava14.phịm.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.phịm.entity.Phim;
import cybersoft.javabackend.moviejava14.phịm.repository.PhimRepository;
import cybersoft.javabackend.moviejava14.phịm.validation.anotation.UniqueBiDanh;

public class UniqueBiDanhValidator implements ConstraintValidator<UniqueBiDanh, String>{

	@Autowired
	private PhimRepository phimRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueBiDanh uniqueBiDanh) {
		ConstraintValidator.super.initialize(uniqueBiDanh);
		this.message = uniqueBiDanh.message();
	}

	@Override
	public boolean isValid(String biDanh, ConstraintValidatorContext context) {
		Optional<Phim> phimOpt = phimRepository.findByBiDanh(biDanh);
		
		if(!phimOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
