package cybersoft.javabackend.moviejava14.cumRap.dto;

import java.util.Set;

import cybersoft.javabackend.moviejava14.rap.dto.RapDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CumRapDTO {
	
	private String maCumRap;
	
	private String tenCumRap;
	
	private String diaChi;
	
	private String maHeThongRap;
	
	private Set<RapDTO> danhSachRap;
}
