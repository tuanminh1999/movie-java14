package cybersoft.javabackend.moviejava14.phịm.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.lichchieu.validation.anotation.ExistedMaLichChieu;
import cybersoft.javabackend.moviejava14.phịm.entity.Phim;
import cybersoft.javabackend.moviejava14.phịm.repository.PhimRepository;

public class ExistedMaPhimValidator implements ConstraintValidator<ExistedMaLichChieu, Integer>{
	
	@Autowired
	private PhimRepository phimRepository;
	
	private String message;
	
	@Override
	public void initialize(ExistedMaLichChieu existedMaLichChieu) {
		ConstraintValidator.super.initialize(existedMaLichChieu);
		this.message = existedMaLichChieu.message();
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
