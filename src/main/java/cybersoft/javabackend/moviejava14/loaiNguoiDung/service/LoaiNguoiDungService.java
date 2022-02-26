package cybersoft.javabackend.moviejava14.loaiNguoiDung.service;

import java.util.Optional;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;

public interface LoaiNguoiDungService {

	Optional<LoaiNguoiDungDTO> findByTenLoaiNguoiDung(String tenLoaiNguoiDung);

}
