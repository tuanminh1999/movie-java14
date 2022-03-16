package cybersoft.javabackend.moviejava14.ghe.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheMapper;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.UpdateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;
import cybersoft.javabackend.moviejava14.loaiGhe.repository.LoaiGheRepository;

public class GheServiceImpl {
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

	@Override
	public LoaiGheDTO create(CreateLoaiGheDTO dto) {
		LoaiGhe loaiGhe = LoaiGheMapper.INSTANCE.fromCreateLoaiGheDTOtoEntity(dto);
		LoaiGhe creteLoaiGhe = loaiGheRepository.save(loaiGhe);
		return LoaiGheMapper.INSTANCE.fromEntityToLoaiGheDTO(creteLoaiGhe);
		
	}

	@Override
	public LoaiGheDTO update(UpdateLoaiGheDTO dto) {
		Optional<LoaiGhe> loaiGheOpt = loaiGheRepository.findById(dto.getId());
		
		if (!loaiGheOpt.isPresent()) {
			throw new InvalidDataException("Id loại ghế không tồn tại");
		}
		
		LoaiGhe loaiGhe = loaiGheOpt.get();
		
		if(!loaiGhe.getTenLoaiGhe().equals(dto.getTenLoaiGhe())) {
			if (loaiGheRepository.findByTenLoaiGhe(dto.getTenLoaiGhe()).isPresent()) {
				throw new InvalidDataException("Tên loại ghế đã tồn tại");
			}
			loaiGhe.setTenLoaiGhe(dto.getTenLoaiGhe());
			loaiGhe.setMoTa(dto.getMoTa());
		}
		
		LoaiGhe updateLoaiGhe = loaiGheRepository.save(loaiGhe);
		
		return LoaiGheMapper.INSTANCE.fromEntityToLoaiGheDTO(updateLoaiGhe);

}
