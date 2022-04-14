package cybersoft.javabackend.moviejava14.cumRap.service;

import cybersoft.javabackend.moviejava14.dtos.AbstractResponse;
import cybersoft.javabackend.moviejava14.dtos.cinemas.CreateCumRapDTO;
import cybersoft.javabackend.moviejava14.dtos.cinemas.CumRapDTO;
import cybersoft.javabackend.moviejava14.dtos.cinemas.UpdateCumRapDTO;

import java.util.List;

public interface CumRapService {

	List<CumRapDTO> findAll();

	AbstractResponse create(CreateCumRapDTO dto);

	CumRapDTO update(UpdateCumRapDTO dto);

	void delete(String maCumRap);

	
}
