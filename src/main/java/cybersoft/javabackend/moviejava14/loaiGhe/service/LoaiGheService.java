package cybersoft.javabackend.moviejava14.loaiGhe.service;

import java.util.Optional;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;

public interface LoaiGheService {

	Optional<LoaiNguoiDungDTO> findByTenLoaiNguoiDung(String tenLoaiNguoiDung);

}
