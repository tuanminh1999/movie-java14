package cybersoft.javabackend.moviejava14.cumRap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.cumRap.dto.CumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.cumRap.repository.CumRapRepository;

@Service
public class CumRapServiceImpl implements CumRapService {
	private CumRapRepository cumRapRepository;
	
	public CumRapServiceImpl(CumRapRepository cumRapRepository) {
		this.cumRapRepository = cumRapRepository;
	}

	@Override
	public List<CumRapDTO> findAll() {
		List<CumRap> cumRaps = cumRapRepository.findAll();
		return null;
	}

}
