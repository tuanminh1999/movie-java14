package cybersoft.javabackend.moviejava14.lichchieu.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.ResponseHandler;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.lichchieu.dto.CreateLichChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.LichChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.service.LichChieuService;

@CrossOrigin
@RestController
public class LichChieuController {
	
	private LichChieuService lichChieuService;
	
	public LichChieuController(LichChieuService lichChieuService) {
		this.lichChieuService = lichChieuService;
	}
	
	@PostMapping(UrlConst.POST_LICH_CHIEU)
	public Object createLichChieu(@RequestHeader String authorization, @Valid @RequestBody CreateLichChieuDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		LichChieuDTO createLichChieu = lichChieuService.create(dto);
		
		return createLichChieu == null ? "Thêm thất bại" : "Thêm thành công";
	}
	
	@GetMapping(UrlConst.GET_THONG_TIN_LICH_CHIEU)
	public Object getThongTinLichChieu(@RequestParam("MaPhim") int maPhim) {
		Object o = lichChieuService.searchThongTinLichChieu(maPhim);
		return new ResponseEntity<Object>(o, HttpStatus.OK); 
	}
	
	@GetMapping(UrlConst.GET_THONG_TIN_LICH_CHIEU_HE_THONG_RAP)
	public Object getThongTinLichChieuHeThongRap(String maHeThongRap) {
		return lichChieuService.searchThongTinLichChieuHeThongRap(maHeThongRap);
	}
}
