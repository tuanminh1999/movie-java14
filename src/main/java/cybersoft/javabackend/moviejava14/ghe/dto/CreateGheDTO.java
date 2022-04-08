package cybersoft.javabackend.moviejava14.ghe.dto;

import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.moviejava14.loaiGhe.validation.annotation.ExistedMaLoaiGhe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGheDTO {
	
	@NotBlank(message = "{ghe.id.not_blank}")
	private String tenGhe;
	
	private boolean daDat;
	
	private int stt;
	
	@NotBlank(message = "{rap.id.not_blank}")
	private String maRap;
	
	@NotBlank(message = "{loai_ghe.id.not_blank}")
	@ExistedMaLoaiGhe
	private String loaiGhe;
}
