package cybersoft.javabackend.moviejava14.loaiGhe.dto;

import cybersoft.javabackend.moviejava14.common.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoaiGheDTO extends BaseDTO {

	private static final long serialVersionUID = -1690300429764562938L;

	private String maLoaiGhe;
	private String tenLoaiGhe;
	private String moTa;
}
