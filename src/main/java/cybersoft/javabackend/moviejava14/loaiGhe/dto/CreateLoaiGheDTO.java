package cybersoft.javabackend.moviejava14.loaiGhe.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.UniqueTenLoaiNguoiDung;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLoaiGheDTO {

	@NotBlank(message = "{loai_ghe.not_blank}")
	@Size(min = 3, max = 50, message = "{loai_ghe.ten.size}")
	@UniqueTenLoaiNguoiDung(message = "{{loai_ghe.ten.unique}")
	private String tenLoaiGhe;
	
	private String moTa;
	
	

}
