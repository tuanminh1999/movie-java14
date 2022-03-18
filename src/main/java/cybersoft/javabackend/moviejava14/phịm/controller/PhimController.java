package cybersoft.javabackend.moviejava14.phịm.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.dto.PageDTO;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.phịm.dto.PhimDTO;
import cybersoft.javabackend.moviejava14.phịm.service.PhimService;

@RestController
@CrossOrigin
public class PhimController {
	
	private PhimService phimService;
	
	public PhimController(PhimService phimService) {
		this.phimService = phimService;
	}
	
	@GetMapping(UrlConst.GET_PHIM)
	public Object getPhims(String tuKhoa) {
		List<PhimDTO> phims = phimService.searchPhim(tuKhoa, null);
		return new ResponseEntity<>(phims, HttpStatus.OK);
	}
	
	@GetMapping(UrlConst.GET_PHIM_BY_DATE_PAGING)
	public Object getPhims(String tuNgay, String denNgay, @RequestParam(defaultValue = "1") int soTrang, 
			@RequestParam(defaultValue = "5") int soPhanTuTrenTrang) {
		if (soTrang <= 0 || soPhanTuTrenTrang <= 0) {
			return new ResponseEntity<>("Số trang hoặc số phần tử trên một trang phải > 0", HttpStatus.BAD_REQUEST);
		}
		Pageable pageable = PageRequest.of(soTrang - 1, soPhanTuTrenTrang);
		PageDTO<PhimDTO> phims = phimService.searchPhimByNgayKhoiChieuPaging(tuNgay, denNgay, pageable);
		return new ResponseEntity<>(phims, HttpStatus.OK);
	}
	
	@PostMapping(UrlConst.POST_PHIM)
	public Object createPhim() {
		
		return null;
	}
	
}
