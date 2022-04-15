package cybersoft.javabackend.moviejava14.rap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.ResponseHandler;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.rap.dto.CreateRapDTO;
import cybersoft.javabackend.moviejava14.rap.dto.RapDTO;
import cybersoft.javabackend.moviejava14.rap.dto.UpdateRapDTO;
import cybersoft.javabackend.moviejava14.rap.service.RapService;

@RestController
public class RapController {
	private RapService rapService;
	
	public RapController(RapService rapService) {
		this.rapService = rapService;
	}
	
	@GetMapping(UrlConst.GET_RAP)
	public Object getRap() {
		List<RapDTO> raps = rapService.findAll();
		return new ResponseEntity<Object>(raps,HttpStatus.OK);
	}
	
	@PostMapping(UrlConst.POST_RAP)
	public Object createRap(@Valid @RequestBody CreateRapDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		RapDTO createdRapDTO = rapService.create(dto);
		return new ResponseEntity<Object>(createdRapDTO,HttpStatus.OK);
	}
	
	@PutMapping(UrlConst.PUT_RAP)
	public Object updateRap(@Valid @RequestBody UpdateRapDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		RapDTO updatedRap = rapService.update(dto);
		return new ResponseEntity<Object>(updatedRap, HttpStatus.OK);
	}
	
	@DeleteMapping(UrlConst.DELETE_RAP)
	public Object deleteRap(String maRap) {
		rapService.delete(maRap);
		return new ResponseEntity<Object>("Xóa rạp thành công", HttpStatus.OK);
	}
}
