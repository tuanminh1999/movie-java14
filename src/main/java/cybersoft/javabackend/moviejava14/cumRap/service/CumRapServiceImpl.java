package cybersoft.javabackend.moviejava14.cumRap.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import cybersoft.javabackend.moviejava14.dtos.AbstractResponse;
import cybersoft.javabackend.moviejava14.dtos.Meta;
import cybersoft.javabackend.moviejava14.dtos.cinemas.CreateCumRapDTO;
import cybersoft.javabackend.moviejava14.dtos.cinemas.CumRapDTO;
import cybersoft.javabackend.moviejava14.dtos.cinemas.CumRapMapper;
import cybersoft.javabackend.moviejava14.dtos.cinemas.UpdateCumRapDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.commones.exeption.ExistedDataException;
import cybersoft.javabackend.moviejava14.commones.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.cumRap.repository.CumRapRepository;
import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.repository.HeThongRapRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackForClassName = {"Exception"})
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
//		List<CumRapDTO> cumRapDTOs = new LinkedList<>();
//		for (CumRap o : cumRaps) {
//			CumRapDTO cr = CumRapMapper.INSTANCE.fromEntityToCumRapDTO(o);
//			cr.setMaHeThongRap(o.getHeThongRap().getMaHeThongRap());
//			cumRapDTOs.add(cr);
//		}
		List<CumRapDTO> cumRapDTOs = cumRaps.stream()
				.map(o -> {
					CumRapDTO cr = CumRapMapper.INSTANCE.fromEntityToCumRapDTO(o);
					cr.setMaHeThongRap(o.getHeThongRap().getMaHeThongRap());
					return cr;
				})
				.collect(Collectors.toList());

		return cumRapDTOs;
	}

	@Override
	public AbstractResponse create(CreateCumRapDTO dto) {
		CumRap cumRap = new CumRap();
		BeanUtils.copyProperties(dto, cumRap);
//		CumRap cumRap = CumRapMapper.INSTANCE.fromCreateCumRapDTOtoEntity(dto);

		HeThongRap heThongRapOpt = heThongRapRepository.findById(dto.getMaHeThongRap())
				.orElse(null);
		if (heThongRapOpt == null)
			return new AbstractResponse(123);
//				.orElseThrow(() -> new InvalidDataException("Hệ thống rạp không tồn tại. "));

		cumRap.setHeThongRap(heThongRapOpt);
		CumRap createCumRap = cumRapRepository.save(cumRap);
		CumRapDTO cumRapDTO = CumRapMapper.INSTANCE.fromEntityToCumRapDTO(createCumRap);
		cumRapDTO.setMaHeThongRap(createCumRap.getHeThongRap().getMaHeThongRap());
		Meta meta = new Meta();
		return new AbstractResponse(cumRapDTO, meta);
	}

	@Override
	public CumRapDTO update(UpdateCumRapDTO dto) {
		CumRap cumRap = cumRapRepository.findById(dto.getMaCumRap())
				.orElseThrow(() -> new InvalidDataException("Mã cụm rạp không tồn tại"));
		if (Objects.equals(cumRap.getTenCumRap(), dto.getTenCumRap())) {

		}

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

		if (cumRapOpt.isEmpty()) {
			throw new InvalidDataException("Mã cụm rạp không tồn tại");
		}

		cumRapRepository.delete(cumRapOpt.get());
	}

}
