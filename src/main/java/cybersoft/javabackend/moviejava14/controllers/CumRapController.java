package cybersoft.javabackend.moviejava14.controllers;

import java.util.List;

import cybersoft.javabackend.moviejava14.dtos.AbstractResponse;
import cybersoft.javabackend.moviejava14.dtos.cinemas.CreateCumRapDTO;
import cybersoft.javabackend.moviejava14.dtos.cinemas.CumRapDTO;
import cybersoft.javabackend.moviejava14.dtos.cinemas.UpdateCumRapDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import cybersoft.javabackend.moviejava14.commones.ResponseHandler;
import cybersoft.javabackend.moviejava14.commones.utils.UrlConst;
import cybersoft.javabackend.moviejava14.cumRap.service.CumRapService;

import javax.validation.Valid;

@RestController
@RequestMapping(UrlConst.URL_CUM_RAP_CONTROLLER)
public class CumRapController extends AbstractController{

	@GetMapping(UrlConst.GET_CUM_RAP)
	public Object getCumRap() {
		List<CumRapDTO> cumRaps = cumRapService.findAll();
		return new ResponseEntity<Object>(cumRaps,HttpStatus.OK);
	}
	
	@PostMapping(UrlConst.POST_CUM_RAP)
	public ResponseEntity<AbstractResponse> createCumRap(@Valid @RequestBody CreateCumRapDTO dto, BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
//		}
		return ResponseEntity.ok().body(cumRapService.create(dto));
	};
	
	@PutMapping(UrlConst.PUT_CUM_RAP)
	public Object updateNguoiDung(@RequestBody UpdateCumRapDTO dto, BindingResult bindingResult) {
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
