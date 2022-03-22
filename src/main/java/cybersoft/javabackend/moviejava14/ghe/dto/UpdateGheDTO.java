package cybersoft.javabackend.moviejava14.ghe.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateGheDTO {
	
	private UUID id;
	
	private int maGhe;

	private String tenGhe;
	
	private int maRap;
	
	private String loaiGhe;
	
	private int giaVe;
	
	private boolean daDat;
	
	private int soThuTU;
	
	private int kichHoat;
	
	private int rapId;
	
	private UUID loaiGheId;

}
