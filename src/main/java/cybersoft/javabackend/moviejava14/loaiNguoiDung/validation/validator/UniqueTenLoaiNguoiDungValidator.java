package cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.repositoty.LoaiNguoiDungRepository;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.UniqueTenLoaiNguoiDung;

public class UniqueTenLoaiNguoiDungValidator implements ConstraintValidator<UniqueTenLoaiNguoiDung, String> {

	@Autowired
	private LoaiNguoiDungRepository loaiNguoiDungRepository;
	
	private String message;
	
	@Override
	public void initialize(UniqueTenLoaiNguoiDung uniqueTenLoaiNguoiDung) {
		ConstraintValidator.super.initialize(uniqueTenLoaiNguoiDung);
		this.message = uniqueTenLoaiNguoiDung.message();
	}
	
	@Override
	public boolean isValid(String tenLoai, ConstraintValidatorContext context) {
		Optional<LoaiNguoiDung> loaiNguoiDungOpt = loaiNguoiDungRepository.findByTenLoai(tenLoai);
		
		if(!loaiNguoiDungOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
