package cybersoft.javabackend.moviejava14.rap.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.rap.dto.CreateRapDTO;
import cybersoft.javabackend.moviejava14.rap.dto.RapDTO;
import cybersoft.javabackend.moviejava14.rap.dto.RapMapper;
import cybersoft.javabackend.moviejava14.rap.dto.UpdateRapDTO;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import cybersoft.javabackend.moviejava14.rap.repository.RapRepository;

@Service
public class RapServiceImpl implements RapService {
	private RapRepository rapRepository;
	
	public RapServiceImpl (RapRepository rapRepository) {
		this.rapRepository = rapRepository;
	}

	@Override
	public List<RapDTO> findAll() {
		List<Rap> raps = rapRepository.findAll();
		return raps.stream().map(o -> RapMapper.INSTANCE.fromEntitytoRapDTO(o)).collect(Collectors.toList());
	}

	@Override
	public RapDTO create(CreateRapDTO dto) {
		Rap rap = RapMapper.INSTANCE.fromCreateRapDTOtoEntity(dto);
		Rap createRap = rapRepository.save(rap);
		
		return RapMapper.INSTANCE.fromEntitytoRapDTO(createRap);
	}

	@Override
	public RapDTO update(UpdateRapDTO dto) {
		/* 1. check maRap co trong repository & lay rap tu repo */
		Optional<Rap> rapOpt = rapRepository.findById(dto.getMaRap());
		if(!rapOpt.isPresent()) {
			throw new InvalidDataException("Mã rạp không tồn tại");
		}
		Rap rap = rapOpt.get();
		/* 2. check cac thuoc tinh trung nhau */
//		if(!rap.getTenRap().equals(dto.getTenRap())) {
//			if(rapRepository.findByTenRap(dto.getTenRap())) {
//				throw new InvalidDataException("Tên rạp đã tồn tại");
//			}
//			rap.setTenRap(dto.getTenRap());
//		}
		/* 3 set cac gia tri dto vao rap */
		rap.setTenRap(dto.getTenRap());
		/* 4 xuat ket qua */
		Rap updatedRap = rapRepository.save(rap);
		return RapMapper.INSTANCE.fromEntitytoRapDTO(updatedRap);
	}

	@Override
	public void delete(String maRap) {
		Optional<Rap> rapOpt = rapRepository.findById(maRap);
		
		if (!rapOpt.isPresent()) {
			throw new InvalidDataException("Mã rạp không tồn tại");
		}
		
		rapRepository.delete(rapOpt.get());
	}
}
