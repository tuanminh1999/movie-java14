package cybersoft.javabackend.moviejava14.nguoiDung.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.UpdateNguoiDungDTO;

@RestController
public class NguoiDungControllerImpl implements NguoiDungController {

	@Override
	public ResponseEntity<Object> getLoaiNguoiDung() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> createNguoiDung(@Valid CreateNguoiDungDTO dto, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> updateNguoiDung(@Valid UpdateNguoiDungDTO dto, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteNguoiDung(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
