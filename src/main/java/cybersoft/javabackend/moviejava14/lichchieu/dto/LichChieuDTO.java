package cybersoft.javabackend.moviejava14.lichchieu.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LichChieuDTO {
	private int maPhim;
	private Timestamp ngayChieuGioChieu;
	private String maRap;
	private int giaVe;
}
