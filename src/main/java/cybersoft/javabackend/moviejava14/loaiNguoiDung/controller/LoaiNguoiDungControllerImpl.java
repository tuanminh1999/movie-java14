package cybersoft.javabackend.moviejava14.loaiNguoiDung.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.service.LoaiNguoiDungService;

@RestController
public class LoaiNguoiDungControllerImpl implements LoaiNguoiDungController{
	@Autowired
	private LoaiNguoiDungService loaiNguoiDungService;
	
//	public LoaiNguoiDungControllerImpl(LoaiNguoiDungService loaiNguoiDungService) {
//		this.loaiNguoiDungService = loaiNguoiDungService;
//	}
	
	@Override
	public ResponseEntity<Object> getLoaiNguoiDung() {
		List<LoaiNguoiDungDTO> loaiNguoiDungs = loaiNguoiDungService.findAll();
		return new ResponseEntity<>(loaiNguoiDungs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createLoaiNguoiDung(@Valid CreateLoaiNguoiDungDTO dto, BindingResult bindingResult) {
		
		return null;
	}

	@Override
	public ResponseEntity<Object> updateLoaiNguoiDung(UUID id, @Valid UpdateLoaiNguoiDungDTO dto, BindingResult bindingResult) {
		
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteLoaiNguoiDung(UUID id) {
		
		return null;
	}

}
