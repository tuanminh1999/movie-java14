package cybersoft.javabackend.moviejava14.rap.dto;

import javax.validation.constraints.NotNull;

import cybersoft.javabackend.moviejava14.rap.validation.anotation.ExistedMaCumRap;
import cybersoft.javabackend.moviejava14.rap.validation.anotation.UniqueMaRap;
import cybersoft.javabackend.moviejava14.rap.validation.anotation.UniqueTenRap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRapDTO {
	
	@NotNull(message = "{rap.ma.not-blank}")
	@UniqueMaRap
	private String maRap;
	
	@NotNull(message = "{rap.ten.not-blank}")
	@UniqueTenRap
	private String tenRap;
	
	@NotNull(message = "{cum_rap.ma.not-blank}")
	@ExistedMaCumRap
	private String maCumRap;

}
