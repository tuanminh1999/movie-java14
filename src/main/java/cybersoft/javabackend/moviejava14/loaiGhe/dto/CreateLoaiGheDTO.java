package cybersoft.javabackend.moviejava14.loaiGhe.dto;

import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.moviejava14.loaiGhe.validation.annotation.UniqueMaLoaiGhe;
import cybersoft.javabackend.moviejava14.loaiGhe.validation.annotation.UniqueTenLoaiGhe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLoaiGheDTO {
	
	@NotBlank(message = "{loai_ghe.id.not_blank}")
	@UniqueMaLoaiGhe
	private String maLoaiGhe;

	@NotBlank(message = "{loai_ghe.ten.not_blank}")
	@UniqueTenLoaiGhe
	private String tenLoaiGhe;
	
	private String moTa;
	
	

}
