package cybersoft.javabackend.moviejava14.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cybersoft.javabackend.moviejava14.security.dto.LoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface AuthController {	
	
	@Operation(method = "get", description = "user login to get token")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "login successfully"),
			@ApiResponse(responseCode = "403", description = "incorect username or password")
	})
	@PostMapping(value = "/api/login", produces = "application/json")
	public ResponseEntity<Object> login(
			@Valid @RequestBody LoginDTO dto, BindingResult bindingResult);
	
}
