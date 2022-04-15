package cybersoft.javabackend.moviejava14.datVe.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.ResponseHandler;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.datVe.dto.CreateDatVeDTO;
import cybersoft.javabackend.moviejava14.datVe.service.DatVeService;

@CrossOrigin
@RestController
public class DatVeController {
	
	private DatVeService datVeService;
	
	public DatVeController(DatVeService datVeService) {
		this.datVeService = datVeService;
	}
	
	@PostMapping(UrlConst.POST_DAT_VE)
	public Object createDatVe(@RequestHeader String authorization, @Valid @RequestBody CreateDatVeDTO dto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}

		String createdDatVe = "";
		
		if(datVeService.create(dto)) {
			createdDatVe = "Đặt vé thành công";
		} else {
			createdDatVe = "Đặt vé thất bại";
		}

		return new ResponseEntity<>(createdDatVe, HttpStatus.OK); 
	}
	
	@GetMapping(UrlConst.GET_DAT_VE)
	public Object getDatVe(@RequestParam("MaLichChieu") int maLichChieu) {
		Object dto =  datVeService.getDatVe(maLichChieu);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
}
