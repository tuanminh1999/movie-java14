package cybersoft.javabackend.moviejava14.nguoiDung.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.UniqueTenLoaiNguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.validation.annotation.UniqueEmailNguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.validation.annotation.UniqueSoDienThoaiNguoiDung;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNguoiDungDTO {

	@NotBlank(message = "{nguoi_dung.tai_khoan.not-blank}")
	@Size(min = 3, max = 30, message = "{nguoi_dung.tai-khoan.size}")
	@UniqueTenLoaiNguoiDung
	private String taiKhoan;
	
	@NotBlank(message = "{nguoi_dung.ten.not_blank}")
	@Size(min = 3, max = 30, message = "{nguoi_dung.ten.size}")
	@UniqueTenLoaiNguoiDung
	private String hoTen;
	
	@NotBlank(message = "{nguoi_dung.mat_khau.not-blank}")
	@Size(min = 8, message = "{nguoi_dung.mat_khau.size}")
	private String matKhau;
	
	@NotBlank(message = "{nguoi_dung.email.not-blank}")
	@UniqueEmailNguoiDung
	private String email;
	
	@NotBlank(message = "{nguoi_dung.so_dien_thoai.not-blank}")
	@Size(min = 10, max = 10, message = "{nguoi_dung.so_dien_thoai.size}")
	@UniqueSoDienThoaiNguoiDung
	private String soDienThoai;
	
	@NotBlank(message = "{loai_nguoi_dung.id.not-blank}")
	private UUID loaiNguoiDungId;

}

