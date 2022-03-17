package cybersoft.javabackend.moviejava14.ghe.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import cybersoft.javabackend.moviejava14.ghe.dto.CreateGheDTO;
import cybersoft.javabackend.moviejava14.ghe.dto.GheDTO;
import cybersoft.javabackend.moviejava14.ghe.dto.UpdateGheDTO;
import cybersoft.javabackend.moviejava14.ghe.service.GheService;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.UpdateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.service.LoaiGheService;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.service.LoaiNguoiDungService;

@RestController
public class GheController {
	
	@Autowired
	private GheService gheService;
	
	public GheController(GheService gheService) {
		this.gheService = gheService;
	}

	@GetMapping(UrlConst.GET_GHE)
	public Object getGhe() {
		List<GheDTO> loaiGhe = gheService.findAll();
		return new ResponseEntity<>(loaiGhe, HttpStatus.OK);
	}
	
	@PostMapping(UrlConst.POST_GHE)
	public Object createGheDTO(@Valid @RequestBody CreateGheDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		GheDTO createGhe = gheService.create(dto); 
		

		return new ResponseEntity<>(createGhe, HttpStatus.OK);
	}

	@PutMapping(UrlConst.PUT_GHE)
	public Object updateGhe( @Valid @RequestBody UpdateGheDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		GheDTO updataGhe=gheService.update(dto);
		return new ResponseEntity<>(updataGhe, HttpStatus.OK);
	}

	@DeleteMapping(UrlConst.DELETE_GHE)

		public Object deleteGhe(UUID id) {
			gheService.delete(id);
			return new ResponseEntity<Object>("Xoá ghế thành công!", HttpStatus.OK);
	}

	

}
