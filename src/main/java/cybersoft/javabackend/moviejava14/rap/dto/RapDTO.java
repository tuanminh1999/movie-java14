package cybersoft.javabackend.moviejava14.rap.dto;

import cybersoft.javabackend.moviejava14.commones.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RapDTO extends BaseDTO {

	private static final long serialVersionUID = 6406279914445291101L;

	private String maRap;

	private String tenRap;
	
	private String maCumRap;
	
}
