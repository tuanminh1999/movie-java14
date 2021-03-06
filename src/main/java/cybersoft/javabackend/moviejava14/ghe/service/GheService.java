package cybersoft.javabackend.moviejava14.ghe.service;

import java.util.List;

import cybersoft.javabackend.moviejava14.ghe.dto.CreateGheDTO;
import cybersoft.javabackend.moviejava14.ghe.dto.GheDTO;
import cybersoft.javabackend.moviejava14.ghe.dto.UpdateGheDTO;

public interface GheService {
	
	List<GheDTO> findAll();
	
	GheDTO create(CreateGheDTO dto);
	
	GheDTO update(UpdateGheDTO dto);

	void delete(int id);

}
