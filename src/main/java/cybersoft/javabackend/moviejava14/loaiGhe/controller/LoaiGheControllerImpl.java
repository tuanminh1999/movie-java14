package cybersoft.javabackend.moviejava14.loaiGhe.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.ResponseHandler;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.UpdateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.service.LoaiGheService;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.service.LoaiNguoiDungService;

@RestController
public class LoaiGheControllerImpl implements LoaiGheController {
	
	@Autowired
	private LoaiGheService loaiGheService;

	@Override
	public ResponseEntity<Object> getLoaiGhe() {
		List<LoaiGheDTO> loaiGhe = loaiGheService.findAll();
		return new ResponseEntity<>(loaiGhe, HttpStatus.OK);
	}
	

	
	@Override
	public ResponseEntity<Object> createLoaiGheDTO(@Valid CreateLoaiGheDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		LoaiGheDTO createLoaiGhe = loaiGheService.create(dto);
		

		return new ResponseEntity<>(createLoaiGhe, HttpStatus.OK);
	}
	
	


	@Override
	public ResponseEntity<Object> updateLoaiGhe( @Valid UpdateLoaiGheDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		LoaiGheDTO updataLoaiGhe=loaiGheService.update(dto);
		return new ResponseEntity<>(updataLoaiGhe, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteLoaiGhe(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
