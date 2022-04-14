package cybersoft.javabackend.moviejava14.lichchieu.dto;

import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.moviejava14.commones.validation.anotation.CorrectDateAndTimeFormat;
import cybersoft.javabackend.moviejava14.lichchieu.validation.anotation.ExistedMaPhim;
import cybersoft.javabackend.moviejava14.lichchieu.validation.anotation.ExistedMaRap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLichChieuDTO {
		
	@ExistedMaPhim
	private int maPhim;
	
	@NotBlank(message = "{phim.ngay_khoi_chieu.not-blank}")
	@CorrectDateAndTimeFormat
	private String ngayChieuGioChieu;
	
	@NotBlank
	@ExistedMaRap
	private String maRap;
	
	private int giaVe;
}
