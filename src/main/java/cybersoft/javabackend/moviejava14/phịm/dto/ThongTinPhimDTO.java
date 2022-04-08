package cybersoft.javabackend.moviejava14.phịm.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThongTinPhimDTO {
	private List<LichChieuPhimDTO> lichChieu;
	private int maPhim;
	private String tenPhim;
	private String biDanh;
	private String trailer;
	private String hinhAnh;
	private String moTa;
	private String ngayKhoiChieu;
	private String danhGia;
}
