package cybersoft.javabackend.moviejava14.nguoiDung.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.ResponseHandler;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.UpdateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.service.NguoiDungService;

@RestController
public class NguoiDungControllerImpl implements NguoiDungController {

	private NguoiDungService nguoiDungService;
	
	public NguoiDungControllerImpl(NguoiDungService nguoiDungService) {
		this.nguoiDungService = nguoiDungService;
	}
	
	@Override
	public ResponseEntity<Object> getNguoiDung() {
		List<NguoiDungDTO> getNguoiDungs = nguoiDungService.findAll();
		return new ResponseEntity<>(getNguoiDungs, HttpStatus.OK);
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

	@Override
	public ResponseEntity<Object> register(@Valid CreateNguoiDungDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		NguoiDungDTO creatednguoiDung = nguoiDungService.create(dto);
		
		return new ResponseEntity<Object>(creatednguoiDung, HttpStatus.OK);
	}
	
}
