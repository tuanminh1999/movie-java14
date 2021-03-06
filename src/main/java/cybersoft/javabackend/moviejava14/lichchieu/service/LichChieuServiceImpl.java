package cybersoft.javabackend.moviejava14.lichchieu.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.common.utils.DateFormatter;
import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.cumRap.repository.CumRapRepository;
import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.heThongRap.repository.HeThongRapRepository;
import cybersoft.javabackend.moviejava14.lichchieu.dto.CreateLichChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.CumRapChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.CumRapChieuHeThongRapDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.HeThongRapChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.LichChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.LichChieuMapper;
import cybersoft.javabackend.moviejava14.lichchieu.dto.PhimChieuHeThongRapDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.ThongTinLichChieuHeThongRapDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.ThongTinLichChieuPhimDTO;
import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import cybersoft.javabackend.moviejava14.lichchieu.repository.LichChieuRepository;
import cybersoft.javabackend.moviejava14.phịm.entity.Phim;
import cybersoft.javabackend.moviejava14.phịm.repository.PhimRepository;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import cybersoft.javabackend.moviejava14.rap.repository.RapRepository;

@Service
public class LichChieuServiceImpl implements LichChieuService {

	@Autowired
	private LichChieuRepository lichChieuRepository;
	@Autowired
	private PhimRepository phimRepository;
	@Autowired
	private RapRepository rapRepository;
	@Autowired
	private CumRapRepository cumRapRepository;
	@Autowired
	private HeThongRapRepository heThongRapRepository;

	@Override
	public LichChieuDTO create(CreateLichChieuDTO dto) {
		LichChieu lichChieu = new LichChieu();
		lichChieu.setGiaVe(dto.getGiaVe());
		lichChieu.setThoiLuong(120);
		lichChieu.setPhim(phimRepository.findById(dto.getMaPhim()).get());
		lichChieu.setRap(rapRepository.findById(dto.getMaRap()).get());
		lichChieu.setNgayGioChieu(DateFormatter.convertStringToDateAndTime(dto.getNgayChieuGioChieu()));
		lichChieu = lichChieuRepository.save(lichChieu);
		LichChieuDTO lichChieuDTO = LichChieuMapper.INSTANCE.fromEntityToLichChieuDTO(lichChieu);
		lichChieuDTO.setMaRap(lichChieu.getRap().getMaRap());
		lichChieuDTO.setTenRap(lichChieu.getRap().getTenRap());
		lichChieuDTO.setNgayChieuGioChieu(lichChieu.getNgayGioChieu().toString().substring(0,19));
		return lichChieuDTO;
	}

	@Override
	public Object searchThongTinLichChieu(int maPhim) {
		ThongTinLichChieuPhimDTO thongTinLichChieuPhimDTO = null;

		Optional<Phim> phim = phimRepository.findById(maPhim);
		if (!phim.isPresent()) {
			throw new InvalidDataException("Mã phim không tồn tại!");
		} else {
			thongTinLichChieuPhimDTO = LichChieuMapper.INSTANCE.fromEntityToThongTinLichChieuDTO(phim.get());
		}

		List<LichChieuDTO> lichChieuList = new ArrayList<LichChieuDTO>();
		LichChieuDTO lichChieuDTO = null;
		Set<Rap> raps = new HashSet<Rap>();
		for (LichChieu lc : phim.get().getLichChieuPhims()) {
			lichChieuDTO = new LichChieuDTO();
			lichChieuDTO = LichChieuMapper.INSTANCE.fromEntityToLichChieuDTO(lc);
			lichChieuDTO.setNgayChieuGioChieu(lc.getNgayGioChieu().toString().substring(0,19));
			lichChieuDTO.setMaRap(lc.getRap().getMaRap());
			raps.add(lc.getRap());
			lichChieuDTO.setTenRap(lc.getRap().getTenRap());
			lichChieuList.add(lichChieuDTO);
		}

		Set<CumRap> cumRaps = new HashSet<CumRap>();
		for (Rap rap : raps) {
			cumRaps.add(rap.getCumRap());
		}

		List<CumRapChieuDTO> cumRapChieuDTOs = new LinkedList<CumRapChieuDTO>();
		CumRapChieuDTO cumRapChieuDTO = null;
		List<LichChieuDTO> dsLichChieuChungCumRap = null;
		List<HeThongRapChieuDTO> heThongRapChieuDTOs = null;
		for (CumRap cumRap : cumRaps) {
			cumRapChieuDTO = new CumRapChieuDTO();
			dsLichChieuChungCumRap = new LinkedList<LichChieuDTO>();
			for (LichChieuDTO o : lichChieuList) {
				if (cumRap.getDanhSachRap().contains(rapRepository.findById(o.getMaRap()).get())) {
					dsLichChieuChungCumRap.add(o);
				}
			}
			cumRapChieuDTO = LichChieuMapper.INSTANCE.fromCumRapEntityToCumRapChieuDTO(cumRap);
			cumRapChieuDTO.setLichChieuPhim(dsLichChieuChungCumRap);
			cumRapChieuDTOs.add(cumRapChieuDTO);

			heThongRapChieuDTOs = new LinkedList<HeThongRapChieuDTO>();
			HeThongRapChieuDTO heThongRapChieuDTO = new HeThongRapChieuDTO();
			heThongRapChieuDTO.setCumRapChieu(cumRapChieuDTOs);
			heThongRapChieuDTO.setMaHeThongRap(cumRap.getHeThongRap().getMaHeThongRap());
			heThongRapChieuDTO.setTenHeThongRap(cumRap.getHeThongRap().getTenHeThongRap());
			heThongRapChieuDTOs.add(heThongRapChieuDTO);
		}
		thongTinLichChieuPhimDTO.setHeThongRapChieu(heThongRapChieuDTOs);

		return thongTinLichChieuPhimDTO;
	}

	@Override
	public Object searchThongTinLichChieuHeThongRap(String maHeThongRap) {
		if (maHeThongRap == null) {
			return searchThongTinLichChieuHeThongRap();
		}

		ThongTinLichChieuHeThongRapDTO thongTinLichChieuHeThongRapDTO = new ThongTinLichChieuHeThongRapDTO();
		Optional<HeThongRap> heThongRap = heThongRapRepository.findById(maHeThongRap);

		if (!heThongRap.isPresent()) {
			throw new InvalidDataException("Mã hệ thống rạp không tồn tại!");
		} else {
			thongTinLichChieuHeThongRapDTO = LichChieuMapper.INSTANCE
					.fromEntityToThongTinLichChieuHeThongRapDTO(heThongRap.get());
		}

		Optional<List<CumRap>> cumRaps = cumRapRepository.findByHeThongRap(heThongRap.get());
		List<CumRapChieuHeThongRapDTO> cumRapChieuHeThongRapList = new ArrayList<CumRapChieuHeThongRapDTO>();
		CumRapChieuHeThongRapDTO cumRapChieuHeThongRapDTO = null;
		for (CumRap cumRap : cumRaps.get()) {
			cumRapChieuHeThongRapDTO = new CumRapChieuHeThongRapDTO();
			cumRapChieuHeThongRapDTO = LichChieuMapper.INSTANCE.fromCumRapEntityToCumRapChieuHeThongRapDTO(cumRap);

			Set<LichChieu> lichChieus = new HashSet<LichChieu>();

			for (Rap o : cumRap.getDanhSachRap()) {
				if (o.getDanhSachLichChieu() != null) {
					for (LichChieu lc : o.getDanhSachLichChieu()) {
						lichChieus.add(lc);
					}
				}
			}

			Set<Phim> phims = new HashSet<Phim>();
			for (LichChieu o : lichChieus) {
				phims.add(o.getPhim());
			}

			List<PhimChieuHeThongRapDTO> phimChieuHeThongRapDTOs = new LinkedList<PhimChieuHeThongRapDTO>();
			PhimChieuHeThongRapDTO phimChieuHeThongRapDTO = null;
			LichChieuDTO lichChieuDTO = null;
			List<LichChieuDTO> lichChieuList = null;
			for (Phim p : phims) {
				phimChieuHeThongRapDTO = new PhimChieuHeThongRapDTO();
				lichChieuList = new LinkedList<LichChieuDTO>();
				for (LichChieu lc : lichChieus) {
					if (p.equals(lc.getPhim())) {
						lichChieuDTO = new LichChieuDTO();
						lichChieuDTO = LichChieuMapper.INSTANCE.fromEntityToLichChieuDTO(lc);
						lichChieuDTO.setMaRap(lc.getRap().getMaRap());
						lichChieuDTO.setTenRap(lc.getRap().getTenRap());
						lichChieuDTO.setNgayChieuGioChieu(lc.getNgayGioChieu().toString().substring(0,19));
						lichChieuList.add(lichChieuDTO);
					}
				}
				phimChieuHeThongRapDTO = LichChieuMapper.INSTANCE.fromPhimEntityPhimChieuHeThongRapDTO(p);
				phimChieuHeThongRapDTO.setLstLichChieuTheoPhim(lichChieuList);
				phimChieuHeThongRapDTOs.add(phimChieuHeThongRapDTO);
			}
			cumRapChieuHeThongRapDTO.setDanhSachPhim(phimChieuHeThongRapDTOs);
			cumRapChieuHeThongRapList.add(cumRapChieuHeThongRapDTO);
		}
		thongTinLichChieuHeThongRapDTO.setLstCumRap(cumRapChieuHeThongRapList);
		return thongTinLichChieuHeThongRapDTO;
	}

	public Object searchThongTinLichChieuHeThongRap() {
		List<ThongTinLichChieuHeThongRapDTO> thongTinLichChieuHeThongRapDTOs = new ArrayList<ThongTinLichChieuHeThongRapDTO>();
		ThongTinLichChieuHeThongRapDTO thongTinLichChieuHeThongRapDTO = null;
		List<HeThongRap> heThongRaps = heThongRapRepository.findAll();

		List<LichChieu> lichChieus = null;
		CumRapChieuHeThongRapDTO cumRapChieuHeThongRapDTO = null;
		List<CumRapChieuHeThongRapDTO> cumRapChieuHeThongRapList = null;

		for (HeThongRap o : heThongRaps) {
			Set<CumRap> cumRaps = o.getDanhSachCumRap();
			cumRapChieuHeThongRapList = new ArrayList<CumRapChieuHeThongRapDTO>();
			thongTinLichChieuHeThongRapDTO = new ThongTinLichChieuHeThongRapDTO();

			for (CumRap cumRap : cumRaps) {
				cumRapChieuHeThongRapDTO = new CumRapChieuHeThongRapDTO();
				cumRapChieuHeThongRapDTO = LichChieuMapper.INSTANCE.fromCumRapEntityToCumRapChieuHeThongRapDTO(cumRap);
				cumRapChieuHeThongRapList.add(cumRapChieuHeThongRapDTO);
			}
			thongTinLichChieuHeThongRapDTO = LichChieuMapper.INSTANCE.fromEntityToThongTinLichChieuHeThongRapDTO(o);
			thongTinLichChieuHeThongRapDTO.setLstCumRap(cumRapChieuHeThongRapList);
			thongTinLichChieuHeThongRapDTOs.add(thongTinLichChieuHeThongRapDTO);

			Set<Rap> raps = new HashSet<Rap>();
			for (CumRapChieuHeThongRapDTO o1 : thongTinLichChieuHeThongRapDTO.getLstCumRap()) {
				for (Rap r : rapRepository.findByCumRap(cumRapRepository.findById(o1.getMaCumRap()).get()).get()) {
					raps.add(r);
				}
			}

			lichChieus = new ArrayList<LichChieu>();
			for (Rap o2 : raps) {
				if (o2.getDanhSachLichChieu() != null) {
					for (LichChieu lc : o2.getDanhSachLichChieu()) {
						lichChieus.add(lc);
					}
				}
			}

			Set<Phim> phims = new HashSet<Phim>();
			for (LichChieu o2 : lichChieus) {
				phims.add(o2.getPhim());
			}

			List<PhimChieuHeThongRapDTO> phimChieuHeThongRapDTOs = new LinkedList<PhimChieuHeThongRapDTO>();
			PhimChieuHeThongRapDTO phimChieuHeThongRapDTO = null;
			LichChieuDTO lichChieuDTO = null;
			List<LichChieuDTO> lichChieuList = null;
			for (Phim p : phims) {
				phimChieuHeThongRapDTO = new PhimChieuHeThongRapDTO();
				lichChieuList = new LinkedList<LichChieuDTO>();
				for (LichChieu lc : lichChieus) {
					if (p.equals(lc.getPhim())) {
						lichChieuDTO = new LichChieuDTO();
						lichChieuDTO = LichChieuMapper.INSTANCE.fromEntityToLichChieuDTO(lc);
						lichChieuDTO.setMaRap(lc.getRap().getMaRap());
						lichChieuDTO.setTenRap(lc.getRap().getTenRap());
						lichChieuDTO.setNgayChieuGioChieu(lc.getNgayGioChieu().toString().substring(0,19));
						lichChieuList.add(lichChieuDTO);
					}
				}
				phimChieuHeThongRapDTO = LichChieuMapper.INSTANCE.fromPhimEntityPhimChieuHeThongRapDTO(p);
				phimChieuHeThongRapDTO.setLstLichChieuTheoPhim(lichChieuList);
				phimChieuHeThongRapDTOs.add(phimChieuHeThongRapDTO);
			}
			cumRapChieuHeThongRapDTO.setDanhSachPhim(phimChieuHeThongRapDTOs);
		}
		
		for (ThongTinLichChieuHeThongRapDTO o : thongTinLichChieuHeThongRapDTOs) {
			Iterator<CumRapChieuHeThongRapDTO> o1 = o.getLstCumRap().iterator();
			while (o1.hasNext()) {
				if (o1.next().getDanhSachPhim() == null) {
					o1.remove();
				}
			}
		}

		return thongTinLichChieuHeThongRapDTOs;
	}

}
