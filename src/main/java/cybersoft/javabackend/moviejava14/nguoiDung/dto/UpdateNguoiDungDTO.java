package cybersoft.javabackend.moviejava14.nguoiDung.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNguoiDungDTO {
	
	@NotBlank(message = "{nguoi_dung.tai_khoan.not-blank}")
	private String taiKhoan;
	
	@NotBlank(message = "{nguoi_dung.ten.not-blank}")
	@Size(min = 3, max = 50, message = "{nguoi_dung.ten.size}")
	private String hoTen;
	
	@NotBlank(message = "{nguoi_dung.email.not-blank}")
	private String email;
	
	@NotBlank(message = "{nguoi_dung.so_dien_thoai.not-blank}")
	private String soDt;
	
	@NotBlank(message = "{loai_nguoi_dung.id.not_blank}")
	private String maLoaiNguoiDung;

}
