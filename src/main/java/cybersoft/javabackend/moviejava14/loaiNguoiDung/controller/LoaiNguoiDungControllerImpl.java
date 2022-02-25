package cybersoft.javabackend.moviejava14.loaiNguoiDung.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;

@RestController
public class LoaiNguoiDungControllerImpl implements LoaiNguoiDungController{

	@Override
	public ResponseEntity<Object> getLoaiNguoiDung() {
		
		return null;
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
