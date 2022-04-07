package cybersoft.javabackend.moviejava14.loaiNguoiDung.service;

import java.util.List;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;

public interface LoaiNguoiDungService {

	LoaiNguoiDungDTO findByTenLoai(String tenLoaiNguoiDung);

	List<LoaiNguoiDungDTO> findAll();
	
	LoaiNguoiDungDTO getNguoiDungById(String id);

	LoaiNguoiDungDTO create(CreateLoaiNguoiDungDTO dto);
	
	LoaiNguoiDungDTO update(UpdateLoaiNguoiDungDTO dto);

	void delete(String id);

}
