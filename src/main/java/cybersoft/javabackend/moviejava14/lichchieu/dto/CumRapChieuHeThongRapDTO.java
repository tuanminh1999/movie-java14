package cybersoft.javabackend.moviejava14.lichchieu.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CumRapChieuHeThongRapDTO {
	private List<PhimChieuHeThongRapDTO> danhSachPhim;
	private String maCumRap;
	private String tenCumRap;
	private String diaChi;
}
