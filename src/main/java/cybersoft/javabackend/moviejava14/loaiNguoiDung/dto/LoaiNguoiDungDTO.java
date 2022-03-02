package cybersoft.javabackend.moviejava14.loaiNguoiDung.dto;

import cybersoft.javabackend.moviejava14.common.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoaiNguoiDungDTO extends BaseDTO {

	private static final long serialVersionUID = -3897381752945484600L;

	private String tenLoaiNguoiDung;

}
