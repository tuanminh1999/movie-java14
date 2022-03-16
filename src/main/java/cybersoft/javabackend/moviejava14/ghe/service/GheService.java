package cybersoft.javabackend.moviejava14.ghe.service;

import java.util.List;
import java.util.Optional;

import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.UpdateLoaiGheDTO;

public interface GheService {
	

	Optional<GheDTO> findByTenGhe(String tenLoaiGhe);

	List<GheDTO> findAll();
	
	GheDTO create(CreateGheDTO dto);
	
	GheDTO update(UpdateGheDTO dto);

}
