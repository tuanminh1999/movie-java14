package cybersoft.javabackend.moviejava14.datVe.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDatVeDTO {	
	private int maLichChieu;
	private List<DanhSachVeDTO> danhSachVe;
	private String taiKhoanNguoiDung;
}
