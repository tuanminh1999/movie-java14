package cybersoft.javabackend.moviejava14.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.ResponseHandler;
import cybersoft.javabackend.moviejava14.security.dto.LoginDTO;
import cybersoft.javabackend.moviejava14.security.service.AuthService;

@RestController
public class AuthControllerImpl implements AuthController {
	
	@Autowired
	private AuthService authService;

	@Override
	public Object login(@Valid LoginDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		Object token = authService.login(dto);
		return new ResponseEntity<>(token, HttpStatus.OK);
	}

}
