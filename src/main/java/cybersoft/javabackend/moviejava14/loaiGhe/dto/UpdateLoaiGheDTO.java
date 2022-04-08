package cybersoft.javabackend.moviejava14.loaiGhe.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLoaiGheDTO {
	
	@NotBlank(message = "{loai_ghe.id.not_blank}")
	private String maLoaiGhe;

	@NotBlank(message = "{loai_ghe.ten.not_blank}")
	private String tenLoaiGhe;
	
	private String moTa;
 
}
