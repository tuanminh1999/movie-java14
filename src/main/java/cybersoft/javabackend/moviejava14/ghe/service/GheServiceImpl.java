package cybersoft.javabackend.moviejava14.ghe.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.ghe.dto.CreateGheDTO;
import cybersoft.javabackend.moviejava14.ghe.dto.GheDTO;
import cybersoft.javabackend.moviejava14.ghe.dto.GheMapper;
import cybersoft.javabackend.moviejava14.ghe.dto.UpdateGheDTO;
import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import cybersoft.javabackend.moviejava14.ghe.repository.GheRepository;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheMapper;
import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;


@Service
public class GheServiceImpl implements GheService {
	private GheRepository gheRepository;
	
	public GheServiceImpl(GheRepository gheRepository) {
		this.gheRepository = gheRepository;
	}
	@Override
	public Optional<GheDTO> findByTenGhe(String tenGhe) {
		Optional<Ghe> ghe = gheRepository.findByTenGhe(tenGhe);
		if (!ghe.isPresent()) {
			return null;
		}
        
		return Optional.ofNullable(GheMapper.INSTANCE.fromEntityToGheDTO(ghe.get()));
		
	}

	@Override
	public List<GheDTO> findAll() {
		List<Ghe> ghe = gheRepository.findAll();

		
		return ghe.stream()
				.map(o -> GheMapper.INSTANCE.fromEntityToGheDTO(o))
				.collect(Collectors.toList());
		
		
	}

	@Override
	public GheDTO create(CreateGheDTO dto) {
		Ghe ghe = GheMapper.INSTANCE.fromCreateGheDTOtoEntity(dto);
		Ghe creteGhe = gheRepository.save(ghe);
		return GheMapper.INSTANCE.fromEntityToGheDTO(creteGhe);
	}

//	@Override
//	public GheDTO update(UpdateGheDTO dto) {
//		Optional<Ghe> gheOpt = gheRepository.findById(dto.getId());
//		
//		if (!gheOpt.isPresent()) {
//			throw new InvalidDataException("Id ghế không tồn tại");
//		}
//		
//		Ghe ghe = gheOpt.get();
//		
//		if(!ghe.getTenGhe().equals(dto.getTenGhe())) {
//			if (gheRepository.findByTenGhe(dto.getTenGhe()).isPresent()) {
//				throw new InvalidDataException("Tên loại ghế đã tồn tại");
//			}
//			ghe.setTenGhe(dto.getTenGhe());
//			ghe.setMoTa(dto.getMoTa());
//		}
//		
//		LoaiGhe updateGhe = gheRepository.save(ghe);
//		
//		return GheMapper.INSTANCE.fromEntityToGheDTO(updateGhe);
//		
//		
//	}
	

	

}
