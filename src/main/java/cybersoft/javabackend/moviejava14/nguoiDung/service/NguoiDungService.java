package cybersoft.javabackend.moviejava14.nguoiDung.service;

import java.util.List;
import java.util.Optional;

import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungProjection;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.UpdateNguoiDungDTO;

public interface NguoiDungService {

	List<NguoiDungProjection> findAllDTO();

	NguoiDungDTO create(CreateNguoiDungDTO dto);

	NguoiDungDTO update(UpdateNguoiDungDTO dto, String token);

	Optional<NguoiDungDTO> getNguoiDungByEmail(String emailNguoiDung);
	
	Optional<NguoiDungDTO> getNguoiDungByTaiKhoan(String taiKhoan);
	
	Optional<NguoiDungDTO> getNguoiDungBySoDt(String soDt);

	void delete(String taiKhoan);

}
