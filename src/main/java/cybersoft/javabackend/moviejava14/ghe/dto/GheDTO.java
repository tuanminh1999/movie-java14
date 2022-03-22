package cybersoft.javabackend.moviejava14.ghe.dto;


import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GheDTO {
	
	private UUID maGhe;

	private String tenGhe;

	private boolean daDat;
	
	private int stt;
		
	private String maRap;
		
	private String loaiGhe;
}
