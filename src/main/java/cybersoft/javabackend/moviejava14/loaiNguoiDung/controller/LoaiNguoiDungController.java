package cybersoft.javabackend.moviejava14.loaiNguoiDung.controller;

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

import cybersoft.javabackend.moviejava14.commones.ResponseHandler;
import cybersoft.javabackend.moviejava14.commones.utils.UrlConst;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.service.LoaiNguoiDungService;

@RestController
public class LoaiNguoiDungController{
	
	private LoaiNguoiDungService loaiNguoiDungService;
	
	public LoaiNguoiDungController(LoaiNguoiDungService loaiNguoiDungService) {
		this.loaiNguoiDungService = loaiNguoiDungService;
	}
	
	@GetMapping(UrlConst.GET_LOAI_NGUOI_DUNG)
	public Object getLoaiNguoiDung() {
		List<LoaiNguoiDungDTO> loaiNguoiDungs = loaiNguoiDungService.findAll();
		return new ResponseEntity<>(loaiNguoiDungs, HttpStatus.OK);
	}
	
	@PostMapping(UrlConst.POST_LOAI_NGUOI_DUNG)
	public Object createLoaiNguoiDung(@Valid @RequestBody CreateLoaiNguoiDungDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		LoaiNguoiDungDTO createdLoaiNguoiDung = loaiNguoiDungService.create(dto);
		
		return new ResponseEntity<>(createdLoaiNguoiDung, HttpStatus.OK);
	}

	@PutMapping(UrlConst.PUT_LOAI_NGUOI_DUNG)
	public Object updateLoaiNguoiDung(@Valid @RequestBody UpdateLoaiNguoiDungDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		LoaiNguoiDungDTO updatedLoaiNguoiDung = loaiNguoiDungService.update(dto);
		
		return new ResponseEntity<>(updatedLoaiNguoiDung, HttpStatus.OK);
	}

	@DeleteMapping(UrlConst.DELETE_LOAI_NGUOI_DUNG)
	public Object deleteLoaiNguoiDung(String maLoaiNguoiDung) {
		loaiNguoiDungService.delete(maLoaiNguoiDung);
		return new ResponseEntity<>("Xoá loại người dùng thành công!", HttpStatus.OK);
	}

}
