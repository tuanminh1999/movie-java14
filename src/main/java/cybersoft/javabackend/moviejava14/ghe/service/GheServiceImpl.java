package cybersoft.javabackend.moviejava14.ghe.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.ghe.dto.CreateGheDTO;
import cybersoft.javabackend.moviejava14.ghe.dto.GheDTO;
import cybersoft.javabackend.moviejava14.ghe.dto.GheMapper;
import cybersoft.javabackend.moviejava14.ghe.dto.UpdateGheDTO;
import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import cybersoft.javabackend.moviejava14.ghe.repository.GheRepository;
import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;
import cybersoft.javabackend.moviejava14.loaiGhe.repository.LoaiGheRepository;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import cybersoft.javabackend.moviejava14.rap.repository.RapRepository;

@Service
public class GheServiceImpl implements GheService {

	private GheRepository gheRepository;
	private LoaiGheRepository loaiGheRepository;
	private RapRepository rapRepository;

	public GheServiceImpl(GheRepository gheRepository, LoaiGheRepository loaiGheRepository,
			RapRepository rapRepository) {
		this.gheRepository = gheRepository;
		this.loaiGheRepository = loaiGheRepository;
		this.rapRepository = rapRepository;
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

		return ghe.stream().map(o -> GheMapper.INSTANCE.fromEntityToGheDTO(o)).collect(Collectors.toList());
	}

	@Override
	public GheDTO create(CreateGheDTO dto) {
		Ghe ghe = GheMapper.INSTANCE.fromCreateGheDTOtoEntity(dto);
		Optional<LoaiGhe> loaiGhe = loaiGheRepository.findById(dto.getLoaiGhe());
		Optional<Rap> rap = rapRepository.findById(dto.getMaRap());
		if (!loaiGhe.isPresent()) {
			throw new InvalidDataException("Loại ghế không tồn tại");
		} else {
			ghe.setLoaiGheEntity(loaiGhe.get());
		}
		if (!rap.isPresent()) {
			throw new InvalidDataException("Rạp không tồn tại");
		} else {
			ghe.setRap(rap.get());
		}
		Ghe createGhe = gheRepository.save(ghe);
		GheDTO gheDTO = GheMapper.INSTANCE.fromEntityToGheDTO(createGhe);
		gheDTO.setLoaiGhe(createGhe.getLoaiGheEntity().getTenLoaiGhe());
		gheDTO.setMaRap(createGhe.getRap().getMaRap());
		return gheDTO;
	}

	@Override
	public GheDTO update(UpdateGheDTO dto) {
		Optional<Ghe> gheOpt = gheRepository.findById(dto.getMaGhe());

		if (!gheOpt.isPresent()) {
			throw new InvalidDataException("Id ghế không tồn tại");
		}

		Ghe ghe = gheOpt.get();

		if (!ghe.getTenGhe().equals(dto.getTenGhe())) {
			if (gheRepository.findByTenGheAndMaRap(dto.getTenGhe(), dto.getMaRap()).isPresent()) {
				throw new InvalidDataException("Tên ghế đã tồn tại");
			}
			ghe.setTenGhe(dto.getTenGhe());
		}

		ghe.setDaDat(dto.isDaDat());

		if (ghe.getStt() != dto.getStt()) {
			if (gheRepository.findBySttAndMaRap(dto.getStt(), dto.getMaRap()).isPresent()) {
				throw new InvalidDataException("Stt ghế đã tồn tại trong rạp này");
			}
			ghe.setStt(dto.getStt());
		}

		ghe.setRap(rapRepository.findById(dto.getMaRap()).get());

		ghe.setLoaiGheEntity(loaiGheRepository.findById(dto.getLoaiGhe()).get());

		Ghe createGhe = gheRepository.save(ghe);
		GheDTO gheDTO = GheMapper.INSTANCE.fromEntityToGheDTO(createGhe);
		gheDTO.setLoaiGhe(createGhe.getLoaiGheEntity().getTenLoaiGhe());
		gheDTO.setMaRap(createGhe.getRap().getMaRap());
		return gheDTO;

	}

	@Override
	public void delete(int id) {
		Optional<Ghe> gheOpt = gheRepository.findById(id);

		if (!gheOpt.isPresent()) {
			throw new InvalidDataException("Id ghế không tồn tại");
		}

		gheRepository.delete(gheOpt.get());
	}

}
