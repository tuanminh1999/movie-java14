package cybersoft.javabackend.moviejava14.phịm.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LichChieuPhimDTO {
	private ThongTinRapDTO thongTinRap;
	private int maLichChieu;
	private String maRap;
	private int maPhim;
	private String tenPhim;
	private Timestamp ngayChieuGioChieu;
	private int giaVe;
	private int thoiLuong;
	
}
