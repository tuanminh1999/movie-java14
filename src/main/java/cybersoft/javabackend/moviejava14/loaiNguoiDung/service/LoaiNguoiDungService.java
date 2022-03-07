package cybersoft.javabackend.moviejava14.loaiNguoiDung.service;

import java.util.List;
import java.util.Optional;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;

public interface LoaiNguoiDungService {

	Optional<LoaiNguoiDungDTO> findByTenLoai(String tenLoaiNguoiDung);

	List<LoaiNguoiDungDTO> findAll();
	
	Optional<LoaiNguoiDungDTO> getNguoiDungById(String id);

	LoaiNguoiDungDTO create(CreateLoaiNguoiDungDTO dto);
	
	LoaiNguoiDungDTO update(UpdateLoaiNguoiDungDTO dto);

	void delete(String id);

}
