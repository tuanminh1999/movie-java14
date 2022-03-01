package cybersoft.javabackend.moviejava14.loaiGhe.service;

import java.util.List;
import java.util.Optional;

import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;

public interface LoaiGheService {

	Optional<LoaiGheDTO> findByTenLoaiGhe(String tenLoaiGhe);

	List<LoaiGheDTO> findAll();

}
