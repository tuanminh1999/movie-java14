package cybersoft.javabackend.moviejava14.rap.service;

import java.util.List;

import cybersoft.javabackend.moviejava14.rap.dto.CreateRapDTO;
import cybersoft.javabackend.moviejava14.rap.dto.RapDTO;
import cybersoft.javabackend.moviejava14.rap.dto.UpdateRapDTO;

public interface RapService {

	List<RapDTO> findAll();

	RapDTO create(CreateRapDTO dto);

	RapDTO update(UpdateRapDTO dto);

	void delete(String maRap);


}
