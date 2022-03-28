package cybersoft.javabackend.moviejava14.lichchieu.service;

import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import cybersoft.javabackend.moviejava14.common.utils.DateFormatter;
import cybersoft.javabackend.moviejava14.lichchieu.dto.CreateLichChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.LichChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.LichChieuMapper;
import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import cybersoft.javabackend.moviejava14.lichchieu.repository.LichChieuRepository;
import cybersoft.javabackend.moviejava14.phịm.repository.PhimRepository;
import cybersoft.javabackend.moviejava14.rap.repository.RapRepository;

@Service
public class LichChieuServiceImpl implements LichChieuService {

	private LichChieuRepository lichChieuRepository;
	private PhimRepository phimRepository;
	private RapRepository rapRepository;
	
	public LichChieuServiceImpl(LichChieuRepository lichChieuRepository, PhimRepository phimRepository, RapRepository rapRepository) {
		this.lichChieuRepository = lichChieuRepository;
		this.phimRepository = phimRepository;
		this.rapRepository = rapRepository;
	}
	
	@Override
	public LichChieuDTO create(CreateLichChieuDTO dto) {
		LichChieu lichChieu = LichChieuMapper.INSTANCE.fromCreateLichChieuDTOToEntity(dto);
		lichChieu.setPhim(phimRepository.findById(dto.getMaPhim()).get());
		lichChieu.setRapLichChieu(rapRepository.findById(dto.getMaRap()).get());
		lichChieu.setNgayChieuGioChieu(DateFormatter.convertStringToDateAndTime(dto.getNgayChieuGioChieu()));
		lichChieu = lichChieuRepository.save(lichChieu);
		LichChieuDTO lichChieuDTO = LichChieuMapper.INSTANCE.fromEntityToLichChieuDTO(lichChieu);
		lichChieuDTO.setMaPhim(lichChieu.getPhim().getMaPhim());
		lichChieuDTO.setMaRap(lichChieu.getRapLichChieu().getMaRap());
		return lichChieuDTO;
	}

}
