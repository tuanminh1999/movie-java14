package cybersoft.javabackend.moviejava14.loaiGhe.controller;

import java.util.List;

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
import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.UpdateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.service.LoaiGheService;

@RestController
public class LoaiGheController {
	
	@Autowired
	private LoaiGheService loaiGheService;

	@GetMapping(UrlConst.GET_LOAI_GHE)
	public Object getLoaiGhe() {
		List<LoaiGheDTO> loaiGhe = loaiGheService.findAll();
		return new ResponseEntity<>(loaiGhe, HttpStatus.OK);
	}
	
	@PostMapping(UrlConst.POST_LOAI_GHE)
	public Object createLoaiGheDTO(@Valid @RequestBody CreateLoaiGheDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		LoaiGheDTO createLoaiGhe = loaiGheService.create(dto); 
		

		return new ResponseEntity<>(createLoaiGhe, HttpStatus.OK);
	}

	@PutMapping(UrlConst.PUT_LOAI_GHE)
	public Object updateLoaiGhe( @Valid @RequestBody UpdateLoaiGheDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		LoaiGheDTO updataLoaiGhe=loaiGheService.update(dto);
		return new ResponseEntity<>(updataLoaiGhe, HttpStatus.OK);
	}

	@DeleteMapping(UrlConst.DELETE_LOAI_GHE)
	public Object deleteLoaiGhe(String id) {
		loaiGheService.delete(id);
		return new ResponseEntity<>("Xoá loại ghế thành công!", HttpStatus.OK);
	}

	

}
