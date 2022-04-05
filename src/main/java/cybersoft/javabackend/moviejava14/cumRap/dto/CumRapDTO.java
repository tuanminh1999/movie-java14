package cybersoft.javabackend.moviejava14.cumRap.dto;

import java.util.List;
import java.util.Set;

import cybersoft.javabackend.moviejava14.rap.dto.RapDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CumRapDTO {
	
	private String maCumRap;
	
	private String tenCumRap;
	
	private String diaChi;
	
	private Set<RapDTO> danhSachRap;
}
