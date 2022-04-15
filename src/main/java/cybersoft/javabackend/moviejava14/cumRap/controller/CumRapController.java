package cybersoft.javabackend.moviejava14.cumRap.controller;

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
import cybersoft.javabackend.moviejava14.cumRap.dto.CreateCumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.dto.CumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.dto.UpdateCumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.service.CumRapService;

@RestController
public class CumRapController {
	
	private CumRapService cumRapService;
	
	public CumRapController (CumRapService cumRapService) {
		this.cumRapService = cumRapService;
	}
	
	@GetMapping(UrlConst.GET_CUM_RAP)
	public Object getCumRap() {
		List<CumRapDTO> cumRaps = cumRapService.findAll();
		return new ResponseEntity<Object>(cumRaps,HttpStatus.OK);
	}
	
	@PostMapping(UrlConst.POST_CUM_RAP)
	public Object createCumRap(@Valid @RequestBody CreateCumRapDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		CumRapDTO createdCumRapDTO = cumRapService.create(dto);
		return new ResponseEntity<Object>(createdCumRapDTO,HttpStatus.OK);
	};
	
	@PutMapping(UrlConst.PUT_CUM_RAP)
	public Object updateNguoiDung(@Valid @RequestBody UpdateCumRapDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		CumRapDTO updatedCumRap = cumRapService.update(dto);
		
		return new ResponseEntity<Object>(updatedCumRap,HttpStatus.OK);
	}
	
	@DeleteMapping(UrlConst.DELETE_CUM_RAP)
	public Object deleteMapping(String maCumRap) {
		cumRapService.delete(maCumRap);
		return new ResponseEntity<Object>("Xóa thành công cụm rap",HttpStatus.OK);
	}
	
	
	
}
