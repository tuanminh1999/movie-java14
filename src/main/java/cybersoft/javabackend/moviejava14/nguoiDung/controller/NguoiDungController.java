package cybersoft.javabackend.moviejava14.nguoiDung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import cybersoft.javabackend.moviejava14.common.dto.PageDTO;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.TaiKhoanNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.ThongTinTaiKhoanDTO;
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
	public Object getNguoiDung(String tuKhoa) {
		List<NguoiDungDTO> getNguoiDungs = nguoiDungService.searchNguoiDung(tuKhoa, null);
		return new ResponseEntity<>(getNguoiDungs, HttpStatus.OK);
	}

	@PostMapping(UrlConst.POST_NGUOI_DUNG)
	public Object createNguoiDung(@RequestHeader String authorization, @Valid @RequestBody CreateNguoiDungDTO dto,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}

		NguoiDungDTO createdNguoiDung = nguoiDungService.create(dto);

		return new ResponseEntity<>(createdNguoiDung, HttpStatus.OK);
	}

	@PutMapping(UrlConst.PUT_NGUOI_DUNG)
	public Object updateNguoiDung(@RequestHeader String authorization, @Valid @RequestBody UpdateNguoiDungDTO dto,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}

		NguoiDungDTO updatedNuoiDung = nguoiDungService.update(dto);

		return new ResponseEntity<Object>(updatedNuoiDung, HttpStatus.OK);
	}

	@DeleteMapping(UrlConst.DELETE_NGUOI_DUNG)
	public Object deleteNguoiDung(@RequestHeader String authorization,
			@RequestParam("TaiKhoan") String taiKhoan) {
		nguoiDungService.delete(taiKhoan);
		return new ResponseEntity<>("Xoá người dùng thành công!", HttpStatus.OK);
	}

	@PostMapping(UrlConst.REGISTER_NGUOI_DUNG)
	public Object register(@Valid @RequestBody CreateNguoiDungDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}

		NguoiDungDTO creatednguoiDung = nguoiDungService.create(dto);

		return new ResponseEntity<Object>(creatednguoiDung, HttpStatus.OK);
	}

	@GetMapping(UrlConst.SEARCH_NGUOIDUNG)
	public Object seachNguoiDung(String tuKhoa) {
		List<NguoiDungDTO> getNguoiDungs = nguoiDungService.searchNguoiDung(tuKhoa, null);
		return new ResponseEntity<>(getNguoiDungs, HttpStatus.OK);
	}

	@GetMapping(UrlConst.GET_NGUOIDUNG_PAGING)
	public Object getNguoiDungPaging(String tuKhoa, @RequestParam(defaultValue = "1") int soTrang,
			@RequestParam(defaultValue = "5") int soPhanTuTrenTrang) {
		if (soTrang <= 0 || soPhanTuTrenTrang <= 0) {
			return new ResponseEntity<>("Số trang hoặc số phần tử trên một trang phải > 0", HttpStatus.BAD_REQUEST);
		}
		Pageable pageable = PageRequest.of(soTrang - 1, soPhanTuTrenTrang);
		PageDTO<NguoiDungDTO> nguoiDungs = nguoiDungService.searchNguoiDungPaging(tuKhoa, pageable);
		return new ResponseEntity<>(nguoiDungs, HttpStatus.OK);
	}

	@GetMapping(UrlConst.SEARCH_NGUOIDUNG_PAGING)
	public Object searchNguoiDungPaging(String tuKhoa,
			@RequestParam(defaultValue = "1") int soTrang, @RequestParam(defaultValue = "5") int soPhanTuTrenTrang) {
		if (soTrang <= 0 || soPhanTuTrenTrang <= 0) {
			return new ResponseEntity<>("Số trang hoặc số phần tử trên một trang phải > 0", HttpStatus.BAD_REQUEST);
		}
		Pageable pageable = PageRequest.of(soTrang - 1, soPhanTuTrenTrang);
		PageDTO<NguoiDungDTO> nguoiDungs = nguoiDungService.searchNguoiDungPaging(tuKhoa, pageable);
		return new ResponseEntity<>(nguoiDungs, HttpStatus.OK);
	}

	@PostMapping(UrlConst.GET_NGUOI_DUNG_FROM_TAIKHOAN)
	public Object getNguoiDungByTaiKhoan(@RequestBody TaiKhoanNguoiDungDTO taiKhoanNguoiDungDTO) {
		ThongTinTaiKhoanDTO thongTinTaiKhoanDTO = nguoiDungService.getThongTinTaiKhoanByTaiKhoan(taiKhoanNguoiDungDTO.getTaiKhoan());
		return new ResponseEntity<Object>(thongTinTaiKhoanDTO, HttpStatus.OK);
	}

}
