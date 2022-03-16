package cybersoft.javabackend.moviejava14.cumRap.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.cumRap.service.CumRapService;

@RestController
public class CumRapController {
	
	private CumRapService cumRapService;
	
	public CumRapController (CumRapService cumRapService) {
		this.cumRapService = cumRapService;
	}
	
	@GetMapping(UrlConst.GET_CUM_RAP)
	public Object getCumRap() {
		return null;
	}
	
	@PostMapping(UrlConst.POST_CUM_RAP)
	public Object createCumRap() {
		return null;
	};
	
	@PutMapping(UrlConst.PUT_CUM_RAP)
	public Object updateNguoiDung() {
		return null;
	}
	
	@DeleteMapping(UrlConst.DELETE_CUM_RAP)
	public Object deleteMapping() {
		return null;
	}
	
	
	
}
