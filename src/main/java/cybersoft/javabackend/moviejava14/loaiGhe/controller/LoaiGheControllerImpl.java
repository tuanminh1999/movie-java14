package cybersoft.javabackend.moviejava14.loaiGhe.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.UpdateLoaiGheDTO;

@RestController
public class LoaiGheControllerImpl implements LoaiGheController {

	

	@Override
	public ResponseEntity<Object> getLoaiNguoiDung() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> createLoaiGhe(@Valid CreateLoaiGheDTO dto, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> updateLoaiGhe(UUID id, @Valid UpdateLoaiGheDTO dto, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteLoaiGhe(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
