package cybersoft.javabackend.moviejava14.datVe.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThongTinPhimDTO {
	private int maLichChieu;
	private String tenCumRap;
	private String tenRap;
	private String diaChi;
	private String tenPhim;
	private String hinhAnh;
	private String ngayChieu;
	private String gioChieu;
}
