package cybersoft.javabackend.moviejava14.nguoiDung.dto;

import cybersoft.javabackend.moviejava14.common.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NguoiDungDTO extends BaseDTO {

	private static final long serialVersionUID = 8859379178070216980L;
	
	private String taiKhoan;
	
	private String hoTen;
	
	private String matKhau;
	
	private String email;
	
	private String soDt;
	
	private String maLoaiNguoiDung;
}
