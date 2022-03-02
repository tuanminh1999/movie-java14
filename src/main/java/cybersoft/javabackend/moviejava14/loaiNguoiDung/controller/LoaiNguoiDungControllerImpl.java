package cybersoft.javabackend.moviejava14.loaiNguoiDung.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.ResponseHandler;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.service.LoaiNguoiDungService;

@RestController
public class LoaiNguoiDungControllerImpl implements LoaiNguoiDungController{

	private LoaiNguoiDungService loaiNguoiDungService;
	
	public LoaiNguoiDungControllerImpl(LoaiNguoiDungService loaiNguoiDungService) {
		this.loaiNguoiDungService = loaiNguoiDungService;
	}
	
	@Override
	public ResponseEntity<Object> getLoaiNguoiDung() {
		List<LoaiNguoiDungDTO> loaiNguoiDungs = loaiNguoiDungService.findAll();
		return new ResponseEntity<>(loaiNguoiDungs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createLoaiNguoiDung(@Valid CreateLoaiNguoiDungDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		LoaiNguoiDungDTO createdLoaiNguoiDung = loaiNguoiDungService.create(dto);
		
		return new ResponseEntity<>(createdLoaiNguoiDung, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updateLoaiNguoiDung(@Valid UpdateLoaiNguoiDungDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		LoaiNguoiDungDTO updatedLoaiNguoiDung = loaiNguoiDungService.update(dto);
		
		return new ResponseEntity<>(updatedLoaiNguoiDung, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteLoaiNguoiDung(UUID id) {
		loaiNguoiDungService.delete(id);
		return new ResponseEntity<>("Xoá loại người dùng thành công!", HttpStatus.OK);
	}

}
