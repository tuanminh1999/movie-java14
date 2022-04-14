package cybersoft.javabackend.moviejava14.loaiGhe.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.commones.exeption.ExistedDataException;
import cybersoft.javabackend.moviejava14.commones.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheMapper;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.UpdateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;
import cybersoft.javabackend.moviejava14.loaiGhe.repository.LoaiGheRepository;

@Service
public class LoaiGheServiceImpl implements LoaiGheService {

	private LoaiGheRepository loaiGheRepository;

	public LoaiGheServiceImpl(LoaiGheRepository loaiGheRepository) {
		this.loaiGheRepository = loaiGheRepository;
	}

	@Override
	public List<LoaiGheDTO> findAll() {
		List<LoaiGhe> loaiGhe = loaiGheRepository.findAll();

		return loaiGhe.stream().map(o -> LoaiGheMapper.INSTANCE.fromEntityToLoaiGheDTO(o)).collect(Collectors.toList());
	}

	@Override
	public LoaiGheDTO create(CreateLoaiGheDTO dto) {
		LoaiGhe loaiGhe = LoaiGheMapper.INSTANCE.fromCreateLoaiGheDTOtoEntity(dto);
		LoaiGhe creteLoaiGhe = loaiGheRepository.save(loaiGhe);
		return LoaiGheMapper.INSTANCE.fromEntityToLoaiGheDTO(creteLoaiGhe);

	}

	@Override
	public LoaiGheDTO update(UpdateLoaiGheDTO dto) {
		Optional<LoaiGhe> loaiGheOpt = loaiGheRepository.findById(dto.getMaLoaiGhe());

		if (!loaiGheOpt.isPresent()) {
			throw new InvalidDataException("Id loại ghế không tồn tại");
		}

		LoaiGhe loaiGhe = loaiGheOpt.get();

		if (!loaiGhe.getTenLoaiGhe().equals(dto.getTenLoaiGhe())) {
			if (loaiGheRepository.findByTenLoaiGhe(dto.getTenLoaiGhe()).isPresent()) {
				throw new ExistedDataException("Tên loại ghế đã tồn tại");
			}
			loaiGhe.setTenLoaiGhe(dto.getTenLoaiGhe());
			loaiGhe.setMoTa(dto.getMoTa());
		}

		LoaiGhe updateLoaiGhe = loaiGheRepository.save(loaiGhe);

		return LoaiGheMapper.INSTANCE.fromEntityToLoaiGheDTO(updateLoaiGhe);

	}

	@Override
	public void delete(String id) {
		Optional<LoaiGhe> loaiGheOpt = loaiGheRepository.findById(id);

		if (!loaiGheOpt.isPresent()) {
			throw new InvalidDataException("Id loại ghế không tồn tại");
		}

		loaiGheRepository.delete(loaiGheOpt.get());
	}

}
