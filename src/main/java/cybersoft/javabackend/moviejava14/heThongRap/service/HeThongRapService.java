package cybersoft.javabackend.moviejava14.heThongRap.service;

import java.util.List;

import cybersoft.javabackend.moviejava14.heThongRap.dto.CreateHeThongRapDTO;
import cybersoft.javabackend.moviejava14.heThongRap.dto.HeThongRapDTO;
import cybersoft.javabackend.moviejava14.heThongRap.dto.UpdateHeThongRapDTO;

public interface HeThongRapService {

	List<HeThongRapDTO> findAll();

	HeThongRapDTO create(CreateHeThongRapDTO dto);

	HeThongRapDTO update(UpdateHeThongRapDTO dto);

	void delete(String maHeThongRap);

}
