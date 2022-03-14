package cybersoft.javabackend.moviejava14.nguoiDung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.ResponseHandler;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungProjection;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.UpdateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.service.NguoiDungService;

@RestController
@CrossOrigin
public class NguoiDungController {

	private NguoiDungService nguoiDungService;
	
	
	public NguoiDungController(NguoiDungService nguoiDungService) {
		this.nguoiDungService = nguoiDungService;
	}
	
	@GetMapping(UrlConst.GET_NGUOI_DUNG)
	public Object getNguoiDung() {
		List<NguoiDungProjection> getNguoiDungs = nguoiDungService.findAllDTO();
		return new ResponseEntity<>(getNguoiDungs, HttpStatus.OK);
	}

	@PostMapping(UrlConst.POST_NGUOI_DUNG)
	public Object createNguoiDung(@RequestHeader String authorization, @Valid @RequestBody CreateNguoiDungDTO dto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		NguoiDungDTO createdNguoiDung = nguoiDungService.create(dto);
		
		return new ResponseEntity<>(createdNguoiDung, HttpStatus.OK);
	}

	@PutMapping(UrlConst.PUT_NGUOI_DUNG)
	public Object updateNguoiDung(@RequestHeader String authorization, @Valid @RequestBody UpdateNguoiDungDTO dto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		NguoiDungDTO updatedNuoiDung = nguoiDungService.update(dto);
		
		return new ResponseEntity<Object>(updatedNuoiDung, HttpStatus.OK);
	}

	@DeleteMapping(UrlConst.DELETE_NGUOI_DUNG)
	public ResponseEntity<Object> deleteNguoiDung(@RequestHeader String authorization, @RequestParam("TaiKhoan") String taiKhoan) {
		nguoiDungService.delete(taiKhoan);
		return new ResponseEntity<Object>("Xoá người dùng thành công!", HttpStatus.OK);
	}

	@PostMapping(UrlConst.REGISTER_NGUOI_DUNG)
	public Object register(@Valid @RequestBody CreateNguoiDungDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		NguoiDungDTO creatednguoiDung = nguoiDungService.create(dto);
		
		return new ResponseEntity<Object>(creatednguoiDung, HttpStatus.OK);
	}
	
}
