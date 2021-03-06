package cybersoft.javabackend.moviejava14.loaiNguoiDung.dto;

import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.validation.annotation.ExistedMaLoaiNguoiDung;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLoaiNguoiDungDTO {

	@NotBlank(message = "{loai_nguoi_dung.id.not_blank}")
	@ExistedMaLoaiNguoiDung
	private String maLoaiNguoiDung;
	
	@NotBlank(message = "{loai_nguoi_dung.ten.not_blank}")
	private String tenLoai;

}
