package cybersoft.javabackend.moviejava14.security.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
	
	@NotBlank
	private String taiKhoan;
	
	@NotBlank
	private String matKhau;
}
