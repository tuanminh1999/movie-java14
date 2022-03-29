package cybersoft.javabackend.moviejava14.lichchieu.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LichChieuDTO {
	private int maLichChieu;
	private Timestamp ngayChieuGioChieu;
	private String maRap;
	private String tenRap;
	private int giaVe;
	private int thoiLuong;
}
