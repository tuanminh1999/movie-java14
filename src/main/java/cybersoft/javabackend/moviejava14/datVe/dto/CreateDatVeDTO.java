package cybersoft.javabackend.moviejava14.datVe.dto;

import java.util.List;

import cybersoft.javabackend.moviejava14.lichchieu.validation.anotation.ExistedMaLichChieu;
import cybersoft.javabackend.moviejava14.nguoiDung.validation.annotation.ExistedTaiKhoanNguoiDung;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDatVeDTO {
	
	@ExistedMaLichChieu
	private int maLichChieu;
	
	private List<DanhSachVeDTO> danhSachVe;
	
	@ExistedTaiKhoanNguoiDung
	private String taiKhoanNguoiDung;
}
