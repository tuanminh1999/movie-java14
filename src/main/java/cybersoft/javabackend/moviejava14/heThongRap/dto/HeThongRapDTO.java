package cybersoft.javabackend.moviejava14.heThongRap.dto;

import java.util.List;

import cybersoft.javabackend.moviejava14.cumRap.dto.CumRapDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeThongRapDTO {
	private String maHeThongRap;
	
	private String tenHeThongRap;
	
	private String biDanh;
	
	private String logo;
	
	private List<CumRapDTO> cumRapDTO;
	
	
}
