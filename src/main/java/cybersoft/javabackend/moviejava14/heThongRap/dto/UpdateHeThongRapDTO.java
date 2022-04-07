package cybersoft.javabackend.moviejava14.heThongRap.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateHeThongRapDTO {

	@NotBlank(message = "{he_thong_rap.ma.not-blank}")
	private String maHeThongRap;
	
	@NotBlank(message = "{he_thong_rap.ten.not-blank}")
	private String tenHeThongRap;
	
	@NotBlank(message = "{he_thong_rap.bi_danh.not-blank}")
	private String biDanh;
	
	private String logo;
}
