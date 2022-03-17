package cybersoft.javabackend.moviejava14.cumRap.service;

import java.util.List;

import cybersoft.javabackend.moviejava14.cumRap.dto.CreateCumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.dto.CumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.dto.UpdateCumRapDTO;

public interface CumRapService {

	List<CumRapDTO> findAll();

	CumRapDTO create(CreateCumRapDTO dto);

	CumRapDTO update(UpdateCumRapDTO dto);

	void delete(String maCumRap);

	
}
