package cybersoft.javabackend.moviejava14.loaiNguoiDung.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;

public interface LoaiNguoiDungService {

	Optional<LoaiNguoiDungDTO> findByTenLoaiNguoiDung(String tenLoaiNguoiDung);

	List<LoaiNguoiDungDTO> findAll();

	LoaiNguoiDungDTO create(CreateLoaiNguoiDungDTO dto);
	
	LoaiNguoiDungDTO update(UpdateLoaiNguoiDungDTO dto);

	void delete(UUID id);

}
