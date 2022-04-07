package cybersoft.javabackend.moviejava14.nguoiDung.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThongTinDatVeDTO {
	private List<DanhSachGheNguoiDungDTO> danhSachGhe;
	private int maVe;
	private Timestamp ngayDat;
	private String tenPhim;
	private int giaVe;
	private int thoiLuongPhim;
}
