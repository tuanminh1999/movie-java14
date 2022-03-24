package cybersoft.javabackend.moviejava14.ghe.dto;


import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateGheDTO {
	
	private int maGhe;

	@NotBlank
	private String tenGhe;

	private boolean daDat;

	private int stt;
	
	@NotBlank
	private String maRap;
		
	@NotBlank
	private String loaiGhe;

}
