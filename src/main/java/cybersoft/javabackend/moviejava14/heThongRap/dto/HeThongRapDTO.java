package cybersoft.javabackend.moviejava14.heThongRap.dto;

import cybersoft.javabackend.moviejava14.commones.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeThongRapDTO extends BaseDTO {

	private static final long serialVersionUID = -7976381903571567795L;

	private String maHeThongRap;
	
	private String tenHeThongRap;
	
	private String biDanh;
	
	private String logo;
	
}
