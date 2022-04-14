package cybersoft.javabackend.moviejava14.ghe.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.commones.exeption.ExistedDataException;
import cybersoft.javabackend.moviejava14.commones.exeption.InvalidDataException;
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
	public List<GheDTO> findAll() {
		List<Ghe> ghes = gheRepository.findAll();
		List<GheDTO> gheDTOs = new LinkedList<GheDTO>();

		for (Ghe o : ghes) {
			GheDTO g = GheMapper.INSTANCE.fromEntityToGheDTO(o);
			g.setLoaiGhe(o.getLoaiGheEntity().getMaLoaiGhe());
			g.setMaRap(o.getRap().getMaRap());
			gheDTOs.add(g);
		}

		return gheDTOs;
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

		if (gheRepository.findByTenGheAndRap(dto.getTenGhe(), ghe.getRap()).isPresent()) {
			throw new ExistedDataException("Tên ghế đã tồn tại trong rạp này");
		} else {
			ghe.setTenGhe(dto.getTenGhe());
		}

		if (gheRepository.findBySttAndRap(dto.getStt(), ghe.getRap()).isPresent()) {
			throw new ExistedDataException("Stt ghế đã tồn tại trong rạp này");
		} else {
			ghe.setStt(dto.getStt());
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
			if (gheRepository.findByTenGheAndRap(dto.getTenGhe(), ghe.getRap()).isPresent()) {
				throw new InvalidDataException("Tên ghế đã tồn tại trong rạp này");
			}
			ghe.setTenGhe(dto.getTenGhe());
		}

		ghe.setDaDat(dto.isDaDat());

		if (ghe.getStt() != dto.getStt()) {
			if (gheRepository.findBySttAndRap(dto.getStt(), ghe.getRap()).isPresent()) {
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
