package cybersoft.javabackend.moviejava14.security.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.security.dto.LoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Đăng nhập", description="Người dùng đăng nhập để lấy token")
public interface AuthController {	
	
	@Operation(method = "get", description = "Người dùng đăng nhập để lấy token")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Đăng nhập thành công"),
			@ApiResponse(responseCode = "403", description = "Sai tài khoản hoặc mật khẩu")
	})
	@PostMapping(value = UrlConst.LOGIN_NGUOI_DUNG, produces = "application/json")
	public Object login(
			@Valid @RequestBody LoginDTO dto, BindingResult bindingResult);
	
}
