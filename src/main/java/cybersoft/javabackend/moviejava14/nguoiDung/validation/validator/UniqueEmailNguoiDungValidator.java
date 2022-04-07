package cybersoft.javabackend.moviejava14.nguoiDung.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.repository.NguoiDungRepository;
import cybersoft.javabackend.moviejava14.nguoiDung.validation.annotation.UniqueEmailNguoiDung;

public class UniqueEmailNguoiDungValidator implements ConstraintValidator<UniqueEmailNguoiDung, String>{

	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueEmailNguoiDung uniqueEmailNguoiDung) {
		ConstraintValidator.super.initialize(uniqueEmailNguoiDung);
		this.message = uniqueEmailNguoiDung.message();
	}
	
	@Override
	public boolean isValid(String emailNguoiDung, ConstraintValidatorContext context) {
		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByEmail(emailNguoiDung);
		
		if(!nguoiDungOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
