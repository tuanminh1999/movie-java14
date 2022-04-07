package cybersoft.javabackend.moviejava14.cumRap.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.ExistedDataException;
import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.cumRap.dto.CreateCumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.dto.CumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.dto.CumRapMapper;
import cybersoft.javabackend.moviejava14.cumRap.dto.UpdateCumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.cumRap.repository.CumRapRepository;
import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.repository.HeThongRapRepository;

@Service
public class CumRapServiceImpl implements CumRapService {

	private CumRapRepository cumRapRepository;
	private HeThongRapRepository heThongRapRepository;

	public CumRapServiceImpl(CumRapRepository cumRapRepository, HeThongRapRepository heThongRapRepository) {
		this.cumRapRepository = cumRapRepository;
		this.heThongRapRepository = heThongRapRepository;
	}

	@Override
	public List<CumRapDTO> findAll() {
		List<CumRap> cumRaps = cumRapRepository.findAll();
		List<CumRapDTO> cumRapDTOs = new LinkedList<CumRapDTO>();
		for (CumRap o : cumRaps) {
			CumRapDTO cr = CumRapMapper.INSTANCE.fromEntityToCumRapDTO(o);
			cr.setMaHeThongRap(o.getHeThongRap().getMaHeThongRap());
			cumRapDTOs.add(cr);
		}

		return cumRapDTOs;
	}

	@Override
	public CumRapDTO create(CreateCumRapDTO dto) {
		CumRap cumRap = CumRapMapper.INSTANCE.fromCreateCumRapDTOtoEntity(dto);

		Optional<HeThongRap> heThongRapOpt = heThongRapRepository.findById(dto.getMaHeThongRap());
		if (!heThongRapOpt.isPresent()) {
			throw new InvalidDataException("Hệ thống rạp không tồn tại. ");
		} else {
			cumRap.setHeThongRap(heThongRapOpt.get());
		}
		CumRap createCumRap = cumRapRepository.save(cumRap);
		CumRapDTO cumRapDTO = CumRapMapper.INSTANCE.fromEntityToCumRapDTO(createCumRap);
		cumRapDTO.setMaHeThongRap(createCumRap.getHeThongRap().getMaHeThongRap());
		return cumRapDTO;
	}

	@Override
	public CumRapDTO update(UpdateCumRapDTO dto) {
		Optional<CumRap> cumRapOpt = cumRapRepository.findById(dto.getMaCumRap());

		if (!cumRapOpt.isPresent()) {
			throw new InvalidDataException("Mã cụm rạp không tồn tại");
		}

		CumRap cumRap = cumRapOpt.get();

		if (!cumRap.getTenCumRap().equals(dto.getTenCumRap())) {

			if (cumRapRepository.findByTenCumRap(dto.getTenCumRap()).isPresent()) {
				throw new ExistedDataException("Tên cụm rạp đã tồn tại");
			}

			cumRap.setTenCumRap(dto.getTenCumRap());

		}

		if (!cumRap.getDiaChi().equals(dto.getDiaChi())) {

			if (cumRapRepository.findByTenCumRap(dto.getTenCumRap()).isPresent()) {
				throw new ExistedDataException("Địa chỉ cụm rạp đã tồn tại");
			}

			cumRap.setDiaChi(dto.getDiaChi());
		}

		CumRap updatedCumRap = cumRapRepository.save(cumRap);
		CumRapDTO cumRapDTO = CumRapMapper.INSTANCE.fromEntityToCumRapDTO(updatedCumRap);
		cumRapDTO.setMaHeThongRap(updatedCumRap.getHeThongRap().getMaHeThongRap());
		return cumRapDTO;
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
