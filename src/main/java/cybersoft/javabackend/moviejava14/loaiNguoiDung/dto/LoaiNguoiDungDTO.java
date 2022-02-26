package cybersoft.javabackend.moviejava14.loaiNguoiDung.dto;

import cybersoft.javabackend.moviejava14.common.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class LoaiNguoiDungDTO extends BaseDTO {

	private String tenLoaiNguoiDung;

}
