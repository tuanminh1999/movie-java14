package cybersoft.javabackend.moviejava14.loaiNguoiDung.dto;

import cybersoft.javabackend.moviejava14.commones.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoaiNguoiDungDTO extends BaseDTO{

	private static final long serialVersionUID = 5557389516229161143L;

	private String maLoaiNguoiDung;
	
	private String tenLoai;

}
