package cybersoft.javabackend.moviejava14.cumRap.dto;

import javax.validation.constraints.NotNull;

import cybersoft.javabackend.moviejava14.cumRap.validation.anotation.ExistedMaHeThongRap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCumRapDTO {
	
	@NotNull(message = "{cum_rap.ma.not-blank}")
	private String maCumRap;
	
	@NotNull(message = "{cum_rap.ten.not-blank}")
	private String tenCumRap;
	
	@NotNull(message = "{cum_rap.dia_chi.not-blank}")
	private String diaChi;
	
	@NotNull(message = "{he_thong_rap.ma.not-blank}")
	@ExistedMaHeThongRap
	private String maHeThongRap;

}
