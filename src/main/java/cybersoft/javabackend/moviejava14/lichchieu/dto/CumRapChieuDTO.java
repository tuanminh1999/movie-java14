package cybersoft.javabackend.moviejava14.lichchieu.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CumRapChieuDTO {
	
	private List<LichChieuDTO> lichChieuPhim;
	private String maCumRap;
	private String tenCumRap;
	private String hinhAnh;
}
