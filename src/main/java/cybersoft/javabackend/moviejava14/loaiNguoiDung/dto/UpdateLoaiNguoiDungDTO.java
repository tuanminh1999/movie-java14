package cybersoft.javabackend.moviejava14.loaiNguoiDung.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLoaiNguoiDungDTO {

	private UUID id;
	
	@NotBlank(message = "{loai_nguoi_dung.ten.not_blank}")
	private String tenLoaiNguoiDung;

}
