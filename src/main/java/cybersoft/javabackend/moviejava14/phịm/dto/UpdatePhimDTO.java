package cybersoft.javabackend.moviejava14.phịm.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.moviejava14.phịm.validation.anotation.CorrectDateFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePhimDTO {
	
	private UUID maPhim;
	
	@NotBlank(message = "{phim.ten_phim.not-blank}")
	private String tenPhim;
	
	@NotBlank(message = "{phim.bi_danh.not-blank}")
	private String biDanh;
	
	@NotBlank(message = "{phim.trailer.not-blank}")
	private String trailer;
	
	@NotBlank(message = "{phim.mo_ta.not-blank}")
	@Size(min = 100, message = "{phim_mo_ta.size}")
	private String moTa;
	
	@NotBlank(message = "{phim.ngay_khoi_chieu.not-blank}")
	@CorrectDateFormat
	private String ngayKhoiChieu;
	
	private int danhGia;
}
