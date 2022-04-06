package cybersoft.javabackend.moviejava14.nguoiDung.dto;

import java.sql.Timestamp;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThongTinDatVeDTO {
	private Set<DanhSachGheNguoiDungDTO> danhSachGhe;
	private int maVe;
	private Timestamp ngayDat;
	private String tenPhim;
	private int giaVe;
	private int thoiLuongPhim;
}
