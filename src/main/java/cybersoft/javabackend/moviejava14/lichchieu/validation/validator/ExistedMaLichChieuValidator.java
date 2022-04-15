package cybersoft.javabackend.moviejava14.lichchieu.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import cybersoft.javabackend.moviejava14.lichchieu.repository.LichChieuRepository;
import cybersoft.javabackend.moviejava14.lichchieu.validation.anotation.ExistedMaLichChieu;

public class ExistedMaLichChieuValidator implements ConstraintValidator<ExistedMaLichChieu, Integer>{
	
	@Autowired
	private LichChieuRepository lichChieuRepository;
	
	private String message;
	
	@Override
	public void initialize(ExistedMaLichChieu existedMaLichChieu) {
		ConstraintValidator.super.initialize(existedMaLichChieu);
		this.message = existedMaLichChieu.message();
	}

	@Override
	public boolean isValid(Integer maLichChieu, ConstraintValidatorContext context) {
		Optional<LichChieu> lichChieuOpt = lichChieuRepository.findById(maLichChieu);
		
		if(lichChieuOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
