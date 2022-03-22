package cybersoft.javabackend.moviejava14.heThongRap.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.heThongRap.dto.CreateHeThongRapDTO;
import cybersoft.javabackend.moviejava14.heThongRap.dto.HeThongRapDTO;
import cybersoft.javabackend.moviejava14.heThongRap.dto.HeThongRapMapper;
import cybersoft.javabackend.moviejava14.heThongRap.dto.UpdateHeThongRapDTO;
import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.repository.HeThongRapRepository;

@Service
public class HeThongRapServiceImpl implements HeThongRapService{
	private HeThongRapRepository heThongRapRepository;
	
	public HeThongRapServiceImpl (HeThongRapRepository heThongRapRepository) {
		this.heThongRapRepository = heThongRapRepository;
	}

	@Override
	public List<HeThongRapDTO> findAll() {
		List<HeThongRap> heThongRaps = heThongRapRepository.findAll();
		// revert heThongRapEntity -> heThongRapDTO
		return heThongRaps
				.stream()
				.map(o -> HeThongRapMapper
						.INSTANCE
						.fromEntityToHeThongRapDTO(o))
				.collect(Collectors.toList());
	}

	@Override
	public HeThongRapDTO create(CreateHeThongRapDTO dto) {
		HeThongRap heThongRap = HeThongRapMapper.INSTANCE.fromCreateHeThongRapDTOtoEntity(dto);
		HeThongRap createHeThongRap = heThongRapRepository.save(heThongRap);
		return HeThongRapMapper.INSTANCE.fromEntityToHeThongRapDTO(createHeThongRap);
	}
	

	@Override
	public HeThongRapDTO update(UpdateHeThongRapDTO dto) {
		Optional<HeThongRap> heThongRapOpt = heThongRapRepository.findById(dto.getMaHeThongRap());
		
		if (!heThongRapOpt.isPresent()) {
			throw new InvalidDataException("Mã hệ thống rạp không tồn tại");
		}
		
		HeThongRap heThongRap = heThongRapOpt.get();
		
		if (!heThongRap.getTenHeThongRap().equals(dto.getTenHeThongRap())) {
			// check ten he thong da ton tai chua
			if (heThongRapRepository.findByTenHeThongRap(dto.getTenHeThongRap()).isPresent()) {
				throw new InvalidDataException("Tên hệ thống rạp đã tồn tại");
			}
			heThongRap.setTenHeThongRap(dto.getTenHeThongRap());
			
		}
		heThongRap.setBiDanh(dto.getBiDanh());
		heThongRap.setLogo(dto.getLogo());
		
		HeThongRap updatedHeThongRap = heThongRapRepository.save(heThongRap);
		
		return HeThongRapMapper.INSTANCE.fromEntityToHeThongRapDTO(updatedHeThongRap);
	}

	@Override
	public void delete(String maHeThongRap) {
		Optional<HeThongRap> heThongRapOpt = heThongRapRepository.findById(maHeThongRap);
		
		if (!heThongRapOpt.isPresent()) {
			throw new InvalidDataException("Mã hệ thống rạp không tồn tại");
		}
		
		heThongRapRepository.delete(heThongRapOpt.get());
		
		
	}
}