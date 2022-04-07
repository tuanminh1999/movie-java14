package cybersoft.javabackend.moviejava14.rap.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.ExistedDataException;
import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.cumRap.repository.CumRapRepository;
import cybersoft.javabackend.moviejava14.rap.dto.CreateRapDTO;
import cybersoft.javabackend.moviejava14.rap.dto.RapDTO;
import cybersoft.javabackend.moviejava14.rap.dto.RapMapper;
import cybersoft.javabackend.moviejava14.rap.dto.UpdateRapDTO;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import cybersoft.javabackend.moviejava14.rap.repository.RapRepository;

@Service
public class RapServiceImpl implements RapService {

	private RapRepository rapRepository;
	private CumRapRepository cumRapRepository;

	public RapServiceImpl(RapRepository rapRepository, CumRapRepository cumRapRepository) {
		this.rapRepository = rapRepository;
		this.cumRapRepository = cumRapRepository;
	}

	@Override
	public List<RapDTO> findAll() {
		List<Rap> raps = rapRepository.findAll();

		List<RapDTO> rapDTOs = new LinkedList<RapDTO>();
		for (Rap o : raps) {
			RapDTO r = RapMapper.INSTANCE.fromEntitytoRapDTO(o);
			r.setMaCumRap(o.getCumRap().getMaCumRap());
			rapDTOs.add(r);
		}

		return rapDTOs;
	}

	@Override
	public RapDTO create(CreateRapDTO dto) {
		Rap rap = RapMapper.INSTANCE.fromCreateRapDTOtoEntity(dto);

		Optional<CumRap> cumRapOpt = cumRapRepository.findById(dto.getMaCumRap());
		if (!cumRapOpt.isPresent()) {
			throw new InvalidDataException("Cụm rạp không tồn tại. ");
		} else {
			rap.setCumRap(cumRapOpt.get());
		}

		Rap createRap = rapRepository.save(rap);
		RapDTO rapDTO = RapMapper.INSTANCE.fromEntitytoRapDTO(createRap);
		rapDTO.setMaCumRap(createRap.getCumRap().getMaCumRap());
		return rapDTO;
	}

	@Override
	public RapDTO update(UpdateRapDTO dto) {
		Optional<Rap> rapOpt = rapRepository.findById(dto.getMaRap());
		if (!rapOpt.isPresent()) {
			throw new InvalidDataException("Mã rạp không tồn tại");
		}

		Rap rap = rapOpt.get();
		if (!rap.getTenRap().equals(dto.getTenRap())) {
			if (rapRepository.findByTenRap(dto.getTenRap()).isPresent()) {
				throw new ExistedDataException("Tên rạp đã tồn tại");
			}
			rap.setTenRap(dto.getTenRap());
		}
		
		Rap updatedRap = rapRepository.save(rap);
		RapDTO rapDTO = RapMapper.INSTANCE.fromEntitytoRapDTO(updatedRap);
		rapDTO.setMaCumRap(updatedRap.getCumRap().getMaCumRap());
		
		return rapDTO;
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
