package cybersoft.javabackend.moviejava14.phịm.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.phịm.dto.PhimDTO;
import cybersoft.javabackend.moviejava14.phịm.service.PhimService;
import cybersoft.javabackend.moviejava14.phịm.validation.anotation.UniqueBiDanh;

public class UniqueBiDanhValidator implements ConstraintValidator<UniqueBiDanh, String>{

	@Autowired
	private PhimService phimService;
	
	private String message;
	
	@Override
	public void initialize(UniqueBiDanh uniqueBiDanh) {
		ConstraintValidator.super.initialize(uniqueBiDanh);
		this.message = uniqueBiDanh.message();
	}

	@Override
	public boolean isValid(String biDanh, ConstraintValidatorContext context) {
		Optional<PhimDTO> phimOpt = phimService.getPhimByBiDanh(biDanh);
		
		if(phimOpt == null) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
