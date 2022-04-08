package cybersoft.javabackend.moviejava14.loaiGhe.service;

import java.util.List;

import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.UpdateLoaiGheDTO;

public interface LoaiGheService {

	List<LoaiGheDTO> findAll();
	
	LoaiGheDTO create(CreateLoaiGheDTO dto);
	
	LoaiGheDTO update(UpdateLoaiGheDTO dto);

	void delete(String id);

}
