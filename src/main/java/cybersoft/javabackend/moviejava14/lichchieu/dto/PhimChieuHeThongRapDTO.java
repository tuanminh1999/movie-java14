package cybersoft.javabackend.moviejava14.lichchieu.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhimChieuHeThongRapDTO {
	
	private List<LichChieuDTO> lstLichChieuTheoPhim;
	private int maPhim;
	private String tenPhim;
	private String hinhAnh;
	
}
