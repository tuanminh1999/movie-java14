package cybersoft.javabackend.moviejava14.heThongRap.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.ResponseHandler;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.heThongRap.dto.CreateHeThongRapDTO;
import cybersoft.javabackend.moviejava14.heThongRap.dto.HeThongRapDTO;
import cybersoft.javabackend.moviejava14.heThongRap.dto.UpdateHeThongRapDTO;
import cybersoft.javabackend.moviejava14.heThongRap.service.HeThongRapService;

@RestController
@CrossOrigin
public class HeThongRapController {

	private HeThongRapService heThongRapService;
	
	public HeThongRapController(HeThongRapService heThongRapService) {
		this.heThongRapService = heThongRapService;
	}
	
	@GetMapping(UrlConst.GET_HT_RAP)
	public Object getHeThongRap() {
		List<HeThongRapDTO> heThongRaps = heThongRapService.findAll();
		return new ResponseEntity<Object>(heThongRaps, HttpStatus.OK);
	}
	
	// chua valid
	@PostMapping(UrlConst.POST_HT_RAP)
	public Object createHeThongRap(@RequestBody CreateHeThongRapDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		HeThongRapDTO createdheThongRapDTO = heThongRapService.create(dto);
		
		return new ResponseEntity<Object>(createdheThongRapDTO,HttpStatus.OK);
	}
	
	// chua valid
	@PutMapping(UrlConst.PUT_HT_RAP)
	public Object updateHeThongRap(@RequestBody UpdateHeThongRapDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		HeThongRapDTO updatedHeThongRap = heThongRapService.update(dto);
		
		return new ResponseEntity<Object>(updatedHeThongRap, HttpStatus.OK);
	}
	
	@DeleteMapping(UrlConst.DELETE_HT_RAP)
	public Object deleteHeThongRap(String maHeThongRap) {
		heThongRapService.delete(maHeThongRap);
		return new ResponseEntity<Object>("Xoá hệ thống rạp thành công",HttpStatus.OK);
	}
		
}
