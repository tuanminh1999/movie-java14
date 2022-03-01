package cybersoft.javabackend.moviejava14.loaiGhe.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheMapper;
import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;
import cybersoft.javabackend.moviejava14.loaiGhe.repository.LoaiGheRepository;

@Service
public class LoaiGheServiceImpl implements LoaiGheService {
	
	private LoaiGheRepository loaiGheRepository;
	public LoaiGheServiceImpl(LoaiGheRepository loaiGheRepository) {
		this.loaiGheRepository = loaiGheRepository;
	}

	@Override
	public Optional<LoaiGheDTO> findByTenLoaiGhe(String tenLoaiGhe) {
		Optional<LoaiGhe> loaiGhe = loaiGheRepository.findByTenLoaiGhe(tenLoaiGhe);
		if (!loaiGhe.isPresent()) {
			return null;
		}
        
		return Optional.ofNullable(LoaiGheMapper.INSTANCE.fromEntityToLoaiGheDTO(loaiGhe.get()));
	}

	@Override
	public List<LoaiGheDTO> findAll() {
		List<LoaiGhe> loaiGhe =  loaiGheRepository.findAll();
		
		return loaiGhe.stream()
				.map(o -> LoaiGheMapper.INSTANCE.fromEntityToLoaiGheDTO(o))
				.collect(Collectors.toList());
	}

}
