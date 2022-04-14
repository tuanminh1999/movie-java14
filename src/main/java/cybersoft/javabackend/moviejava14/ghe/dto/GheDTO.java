package cybersoft.javabackend.moviejava14.ghe.dto;


import cybersoft.javabackend.moviejava14.commones.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GheDTO extends BaseDTO{
	
	private static final long serialVersionUID = -446978804635715178L;

	private int maGhe;

	private String tenGhe;

	private boolean daDat;
	
	private int stt;
		
	private String maRap;
		
	private String loaiGhe;
}
