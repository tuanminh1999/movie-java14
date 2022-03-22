package cybersoft.javabackend.moviejava14.ghe.service;

import java.util.List;
import java.util.Optional;

import cybersoft.javabackend.moviejava14.ghe.dto.CreateGheDTO;
import cybersoft.javabackend.moviejava14.ghe.dto.GheDTO;

public interface GheService {
	

	Optional<GheDTO> findByTenGhe(String tenGhe);

	List<GheDTO> findAll();
	
	GheDTO create(CreateGheDTO dto);
	
//	GheDTO update(UpdateGheDTO dto);

}
