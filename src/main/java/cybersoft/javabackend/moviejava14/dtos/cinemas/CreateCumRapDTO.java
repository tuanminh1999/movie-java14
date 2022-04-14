package cybersoft.javabackend.moviejava14.dtos.cinemas;

import cybersoft.javabackend.moviejava14.cumRap.validation.anotation.UniqueDiaChiCumRap;
import cybersoft.javabackend.moviejava14.cumRap.validation.anotation.UniqueMaCumRap;
import cybersoft.javabackend.moviejava14.cumRap.validation.anotation.UniqueTenCumRap;
import cybersoft.javabackend.moviejava14.heThongRap.validation.anotation.ExistedMaHeThongRap;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateCumRapDTO {
	
	@NotNull(message = "{cum_rap.ma.not-blank}")
	@UniqueMaCumRap
	private String maCumRap;
	
	@NotNull(message = "{cum_rap.ten.not-blank}")
	@UniqueTenCumRap
	private String tenCumRap;
	
	@NotNull(message = "{cum_rap.dia_chi.not-blank}")
	@UniqueDiaChiCumRap
	private String diaChi;
	
	@NotNull(message = "{he_thong_rap.ma.not-blank}")
	@ExistedMaHeThongRap
	private String maHeThongRap;
}
