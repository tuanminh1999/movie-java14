package cybersoft.javabackend.moviejava14.loaiNguoiDung.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.UniqueTenLoaiNguoiDung;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLoaiNguoiDungDTO {
	
	@NotBlank(message = "{loai_nguoi_dung.ten.not_blank}")
	@Size(min = 3, max = 50, message = "{loai_nguoi_dung.ten.size}")
	@UniqueTenLoaiNguoiDung(message = "{{loai_nguoi_dung.ten.unique}")
	private String tenLoaiNguoiDung;
	
}
