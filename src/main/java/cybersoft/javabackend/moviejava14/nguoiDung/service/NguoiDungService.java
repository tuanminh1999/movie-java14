package cybersoft.javabackend.moviejava14.nguoiDung.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import cybersoft.javabackend.moviejava14.commones.dto.PageDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.ThongTinTaiKhoanDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.UpdateNguoiDungDTO;

public interface NguoiDungService {

	NguoiDungDTO create(CreateNguoiDungDTO dto);

	NguoiDungDTO update(UpdateNguoiDungDTO dto);
	
	ThongTinTaiKhoanDTO getThongTinTaiKhoanByTaiKhoan(String taiKhoan);
	
	void delete(String taiKhoan);
	
	List<NguoiDungDTO> searchNguoiDung(String tuKhoa, Pageable pageable);

	PageDTO<NguoiDungDTO> searchNguoiDungPaging(String tuKhoa, Pageable pageable);

}
