package cybersoft.javabackend.moviejava14.lichchieu.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeThongRapChieuDTO {
	
	private List<CumRapChieuDTO> cumRapChieu;
	private String maHeThongRap;
	private String tenHeThongRap;
	private String logo;
	
}
