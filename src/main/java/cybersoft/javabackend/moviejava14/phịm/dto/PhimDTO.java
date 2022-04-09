package cybersoft.javabackend.moviejava14.phịm.dto;

import java.sql.Timestamp;

import cybersoft.javabackend.moviejava14.common.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhimDTO extends BaseDTO{
	
	private static final long serialVersionUID = 4847018855582645976L;
	
	private int maPhim;
	private String tenPhim;
	private String biDanh;
	private String trailer;
	private String hinhAnh;
	private String moTa;
	private Timestamp ngayKhoiChieu;
	private int danhGia;
}
