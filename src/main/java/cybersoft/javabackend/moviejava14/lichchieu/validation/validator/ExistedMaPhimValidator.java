package cybersoft.javabackend.moviejava14.lichchieu.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.lichchieu.validation.anotation.ExistedMaPhim;
import cybersoft.javabackend.moviejava14.phịm.entity.Phim;
import cybersoft.javabackend.moviejava14.phịm.repository.PhimRepository;

public class ExistedMaPhimValidator implements ConstraintValidator<ExistedMaPhim, Integer>{
	
	@Autowired
	private PhimRepository phimRepository;
	
	private String message;
	
	@Override
	public void initialize(ExistedMaPhim existedMaPhim) {
		ConstraintValidator.super.initialize(existedMaPhim);
		this.message = existedMaPhim.message();
	}

	@Override
	public boolean isValid(Integer maPhim, ConstraintValidatorContext context) {
		Optional<Phim> phimOpt = phimRepository.findById(maPhim);
		
		if(phimOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
