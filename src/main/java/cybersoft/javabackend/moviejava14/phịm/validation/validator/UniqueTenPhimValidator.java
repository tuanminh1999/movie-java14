package cybersoft.javabackend.moviejava14.phịm.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.phịm.entity.Phim;
import cybersoft.javabackend.moviejava14.phịm.repository.PhimRepository;
import cybersoft.javabackend.moviejava14.phịm.validation.anotation.UniqueTenPhim;

public class UniqueTenPhimValidator implements ConstraintValidator<UniqueTenPhim, String>{
	
	@Autowired
	private PhimRepository phimRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueTenPhim uniqueTenPhim) {
		ConstraintValidator.super.initialize(uniqueTenPhim);
		this.message = uniqueTenPhim.message();
	}

	@Override
	public boolean isValid(String tenPhim, ConstraintValidatorContext context) {
		Optional<Phim> phimOpt = phimRepository.findByTenPhim(tenPhim);
		
		if(!phimOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
