package cybersoft.javabackend.moviejava14.loaiNguoiDung.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLoaiNguoiDungDTO {

	private UUID id;
	private String tenLoaiNguoiDung;

}
