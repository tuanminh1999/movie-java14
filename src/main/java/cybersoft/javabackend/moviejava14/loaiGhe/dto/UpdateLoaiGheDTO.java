package cybersoft.javabackend.moviejava14.loaiGhe.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLoaiGheDTO {
	
	private UUID id;
	private String tenLoaiGhe;
	private String moTa;
 
}
