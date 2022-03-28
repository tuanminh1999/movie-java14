package cybersoft.javabackend.moviejava14.phịm.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhimDTO {
	private int maPhim;
	private String tenPhim;
	private String biDanh;
	private String trailer;
	private String hinhAnh;
	private String moTa;
	private Timestamp ngayKhoiChieu;
	private int danhGia;
}
