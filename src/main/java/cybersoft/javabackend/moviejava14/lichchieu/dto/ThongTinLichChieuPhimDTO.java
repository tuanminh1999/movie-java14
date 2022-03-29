package cybersoft.javabackend.moviejava14.lichchieu.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThongTinLichChieuPhimDTO {
	
	private int maPhim;
	private String tenPhim;
	private String biDanh;
	private String trailer;
	private String hinhAnh;
	private String moTa;
	private Timestamp ngayKhoiChieu;
	private int danhGia;
	private List<HeThongRapChieuDTO> heThongRapChieu;
	
}
