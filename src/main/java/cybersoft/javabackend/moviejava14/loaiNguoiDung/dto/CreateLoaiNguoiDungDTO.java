package cybersoft.javabackend.moviejava14.loaiNguoiDung.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.UniqueMaLoaiNguoiDung;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.UniqueTenLoaiNguoiDung;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLoaiNguoiDungDTO {
	
	@NotBlank(message = "{loai_nguoi_dung.id.not_blank}")
	@Size(min = 3, max = 20, message = "{loai_nguoi_dung.id.size}")
	@UniqueMaLoaiNguoiDung
	private String id;

	@NotBlank(message = "{loai_nguoi_dung.ten.not_blank}")
	@Size(min = 3, max = 30, message = "{loai_nguoi_dung.ten.size}")
	@UniqueTenLoaiNguoiDung
	private String tenLoaiNguoiDung;

}

