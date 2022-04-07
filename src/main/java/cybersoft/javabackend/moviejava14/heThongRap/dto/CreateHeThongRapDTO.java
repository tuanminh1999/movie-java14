package cybersoft.javabackend.moviejava14.heThongRap.dto;

import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.moviejava14.heThongRap.validation.anotation.UniqueBiDanhHeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.validation.anotation.UniqueMaHeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.validation.anotation.UniqueTenHeThongRap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateHeThongRapDTO {
	
	@NotBlank(message = "{he_thong_rap.ma.not-blank}")
	@UniqueMaHeThongRap
	private String maHeThongRap;
	
	@NotBlank(message = "{he_thong_rap.ten.not-blank}")
	@UniqueTenHeThongRap
	private String tenHeThongRap;
	
	@NotBlank(message = "{he_thong_rap.bi_danh.not-blank}")
	@UniqueBiDanhHeThongRap
	private String biDanh;
	
	private String logo;
}
