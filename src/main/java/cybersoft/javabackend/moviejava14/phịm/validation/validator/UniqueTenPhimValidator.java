package cybersoft.javabackend.moviejava14.phịm.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.phịm.dto.PhimDTO;
import cybersoft.javabackend.moviejava14.phịm.service.PhimService;
import cybersoft.javabackend.moviejava14.phịm.validation.anotation.UniqueTenPhim;

public class UniqueTenPhimValidator implements ConstraintValidator<UniqueTenPhim, String>{
	
	@Autowired
	private PhimService phimService;
	
	private String message;
	
	@Override
	public void initialize(UniqueTenPhim uniqueTenPhim) {
		ConstraintValidator.super.initialize(uniqueTenPhim);
		this.message = uniqueTenPhim.message();
	}

	@Override
	public boolean isValid(String tenPhim, ConstraintValidatorContext context) {
		Optional<PhimDTO> phimOpt = phimService.getPhimByTenPhim(tenPhim);
		
		if(phimOpt == null) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
