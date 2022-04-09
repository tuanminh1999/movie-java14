package cybersoft.javabackend.moviejava14.lichchieu.dto;

import cybersoft.javabackend.moviejava14.common.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LichChieuDTO extends BaseDTO{
	
	private static final long serialVersionUID = -1312573701135929190L;
	
	private int maLichChieu;
	private String maRap;
	private String tenRap;
	private String ngayChieuGioChieu;
	private int giaVe;
	private int thoiLuong;
}
