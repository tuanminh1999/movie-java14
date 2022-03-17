package cybersoft.javabackend.moviejava14.cumRap.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.cumRap.dto.CreateCumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.dto.CumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.dto.CumRapMapper;
import cybersoft.javabackend.moviejava14.cumRap.dto.UpdateCumRapDTO;
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
		return cumRaps
				.stream()
				.map(o -> CumRapMapper.INSTANCE.fromEntityToCumRapDTO(o))
				.collect(Collectors.toList());
	}

	@Override
	public CumRapDTO create(CreateCumRapDTO dto) {
		CumRap cumRap = CumRapMapper.INSTANCE.fromCreateCumRapDTOtoEntity(dto);
		CumRap createCumRap = cumRapRepository.save(cumRap);
		
		return CumRapMapper.INSTANCE.fromEntityToCumRapDTO(createCumRap);
	}

	@Override
	public CumRapDTO update(UpdateCumRapDTO dto) {
		Optional<CumRap> cumRapOpt = cumRapRepository.findById(dto.getMaCumRap());
		
		if(!cumRapOpt.isPresent()) {
			throw new InvalidDataException("Mã cụm rạp không tồn tại");
		}
		
		CumRap cumRap = cumRapOpt.get();
		if (!cumRap.getTenCumRap().equals(dto.getTenCumRap())) {
			if (cumRapRepository.findByTenCumRap(dto.getTenCumRap())) {
				throw new InvalidDataException("Tên cụm rạp đã tồn tại");
			}
			cumRap.setTenCumRap(dto.getTenCumRap());
			
		}
		// check dia chi trung ???
		cumRap.setDiaChi(dto.getDiaChi());;
		CumRap updatedCumRap = cumRapRepository.save(cumRap);
		return CumRapMapper.INSTANCE.fromEntityToCumRapDTO(updatedCumRap);
	}

	@Override
	public void delete(String maCumRap) {
		Optional<CumRap> cumRapOpt = cumRapRepository.findById(maCumRap);
		
		if (!cumRapOpt.isPresent()) {
			throw new InvalidDataException("Mã cụm rạp không tồn tại");
		}
		
		cumRapRepository.delete(cumRapOpt.get());
	}

}
