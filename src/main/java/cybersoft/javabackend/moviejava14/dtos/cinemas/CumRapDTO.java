package cybersoft.javabackend.moviejava14.dtos.cinemas;

import cybersoft.javabackend.moviejava14.rap.dto.RapDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CumRapDTO {
	
	private String maCumRap;
	
	private String tenCumRap;
	
	private String diaChi;
	
	private String maHeThongRap;
	
	private Set<RapDTO> danhSachRap;
}
