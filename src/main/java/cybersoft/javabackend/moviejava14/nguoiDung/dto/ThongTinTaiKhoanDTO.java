package cybersoft.javabackend.moviejava14.nguoiDung.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThongTinTaiKhoanDTO {
	private String taiKhoan;
	private String matKhau;
	private String hoTen;
	private String email;
	private String soDT;
	private String loaiNguoiDung;
	private List<ThongTinDatVeDTO> thongTinDatVe;
}
