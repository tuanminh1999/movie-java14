package cybersoft.javabackend.moviejava14.datVe.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DatVeDTO {
	
	private ThongTinPhimDTO thongTinPhim;
	private List<DanhSachGheDTO> danhSachGhe;
	
}
