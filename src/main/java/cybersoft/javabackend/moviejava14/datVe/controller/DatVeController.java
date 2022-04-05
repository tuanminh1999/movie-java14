package cybersoft.javabackend.moviejava14.datVe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
	public Object createDatVe(@RequestHeader String authorization, @RequestBody CreateDatVeDTO dto) {

//		if (bindingResult.hasErrors()) {
//			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
//		}

		Object createdDatVe = datVeService.create(dto);

		return createdDatVe == null ? "Đặt vé thất bại" : "Đặt vé thành công";
	}
	
	
}
