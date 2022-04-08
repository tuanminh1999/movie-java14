package cybersoft.javabackend.moviejava14.rap.dto;

import javax.validation.constraints.NotNull;

import cybersoft.javabackend.moviejava14.cumRap.validation.anotation.ExistedMaCumRap;
import cybersoft.javabackend.moviejava14.lichchieu.validation.anotation.ExistedMaRap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRapDTO {
	
	@NotNull(message = "{rap.ma.not-blank}")
	@ExistedMaRap
	private String maRap;
	
	@NotNull(message = "{rap.ten.not-blank}")
	private String tenRap;
	
	@NotNull(message = "{cum_rap.ma.not-blank}")
	@ExistedMaCumRap
	private String maCumRap;
}
