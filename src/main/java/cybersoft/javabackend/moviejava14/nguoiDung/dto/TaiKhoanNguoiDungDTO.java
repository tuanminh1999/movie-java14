package cybersoft.javabackend.moviejava14.nguoiDung.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaiKhoanNguoiDungDTO {

	@NotBlank(message = "{nguoi_dung.tai_khoan.not-blank}")
	private String taiKhoan;
}

