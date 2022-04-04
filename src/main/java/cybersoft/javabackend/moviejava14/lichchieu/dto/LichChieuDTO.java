package cybersoft.javabackend.moviejava14.lichchieu.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LichChieuDTO {
	private String maLichChieu;
	private String maRap;
	private String tenRap;
	private Timestamp ngayChieuGioChieu;
	private int giaVe;
	private int thoiLuong;
}
