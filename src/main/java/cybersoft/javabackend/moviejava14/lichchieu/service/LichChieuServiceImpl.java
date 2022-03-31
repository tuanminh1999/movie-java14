package cybersoft.javabackend.moviejava14.lichchieu.service;

import java.util.ArrayList;
import java.util.HashSet;
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
		lichChieu.setRapLichChieu(rapRepository.findById(dto.getMaRap()).get());
		lichChieu.setNgayChieuGioChieu(DateFormatter.convertStringToDateAndTime(dto.getNgayChieuGioChieu()));
		lichChieu = lichChieuRepository.save(lichChieu);
		LichChieuDTO lichChieuDTO = LichChieuMapper.INSTANCE.fromEntityToLichChieuDTO(lichChieu);
		lichChieuDTO.setMaRap(lichChieu.getRapLichChieu().getMaRap());
		lichChieuDTO.setTenRap(lichChieu.getRapLichChieu().getTenRap());
		return lichChieuDTO;
	}

	@Override
	public Object searchThongTinLichChieu(int maPhim) {
		ThongTinLichChieuPhimDTO thongTinLichChieuPhimDTO = new ThongTinLichChieuPhimDTO();
		Optional<Phim> phim = phimRepository.findById(maPhim);
		if (!phim.isPresent()) {
			throw new InvalidDataException("Mã phim không tồn tại!");
		} else {
			thongTinLichChieuPhimDTO = LichChieuMapper.INSTANCE.fromEntityToThongTinLichChieuDTO(phim.get());
		}

		Optional<List<LichChieu>> lichChieus = lichChieuRepository.findByPhim(phim.get());
		List<LichChieuDTO> lichChieuList = new ArrayList<LichChieuDTO>();
		LichChieuDTO lichChieuDTO = null;
		Set<String> maRaps = new HashSet<String>();
		for (LichChieu lc : lichChieus.get()) {
			lichChieuDTO = new LichChieuDTO();
			lichChieuDTO.setMaLichChieu(lc.getMaLichChieu());
			lichChieuDTO.setGiaVe(lc.getGiaVe());
			lichChieuDTO.setMaRap(lc.getRapLichChieu().getMaRap());
			maRaps.add(lichChieuDTO.getMaRap());
			lichChieuDTO.setNgayChieuGioChieu(lc.getNgayChieuGioChieu());
			lichChieuDTO.setTenRap(lc.getRapLichChieu().getTenRap());
			lichChieuDTO.setThoiLuong(lc.getThoiLuong());
			lichChieuList.add(lichChieuDTO);
		}

		Set<String> maCumRaps = new HashSet<String>();
		List<CumRapChieuDTO> cumRapChieuDTOs = new LinkedList<CumRapChieuDTO>();
		CumRapChieuDTO cumRapChieuDTO = null;
		List<LichChieuDTO> lichChieuList1 = null;
		for (String maRap : maRaps) {
			cumRapChieuDTO = new CumRapChieuDTO();
			lichChieuList1 = new LinkedList<LichChieuDTO>();
			for (LichChieuDTO o : lichChieuList) {
				if (maRap.equals(o.getMaRap())) {
					lichChieuList1.add(o);
				}
			}
			cumRapChieuDTO.setLichChieuPhim(lichChieuList1);
			cumRapChieuDTO.setHinhAnh(null);
			cumRapChieuDTO.setMaCumRap(rapRepository.getById(maRap).getCumRap().getMaCumRap());
			maCumRaps.add(cumRapChieuDTO.getMaCumRap());
			cumRapChieuDTO.setTenCumRap(rapRepository.getById(maRap).getCumRap().getTenCumRap());
			cumRapChieuDTOs.add(cumRapChieuDTO);
		}

		HeThongRapChieuDTO heThongRapChieuDTO = null;
		List<CumRapChieuDTO> cumRapList = null;
		List<HeThongRapChieuDTO> heThongRapChieuDTOs = new LinkedList<HeThongRapChieuDTO>();
		for (String maCumRap : maCumRaps) {
			heThongRapChieuDTO = new HeThongRapChieuDTO();
			cumRapList = new LinkedList<CumRapChieuDTO>();
			for (CumRapChieuDTO o : cumRapChieuDTOs) {
				if (maCumRap.equals(o.getMaCumRap())) {
					cumRapList.add(o);
				}
			}
			heThongRapChieuDTO.setCumRapChieu(cumRapList);
			heThongRapChieuDTO.setMaHeThongRap(
					cumRapRepository.getById(cumRapChieuDTO.getMaCumRap()).getHeThongRap().getMaHeThongRap());
			heThongRapChieuDTO.setTenHeThongRap(
					cumRapRepository.getById(cumRapChieuDTO.getMaCumRap()).getHeThongRap().getTenHeThongRap());
			heThongRapChieuDTOs.add(heThongRapChieuDTO);
		}
		thongTinLichChieuPhimDTO.setHeThongRapChieu(heThongRapChieuDTOs);
		return thongTinLichChieuPhimDTO;
	}

	@Override
	public Object searchThongTinLichChieuHeThongRap(String maHeThongRap) {
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
			cumRapChieuHeThongRapDTO.setDiaChi(cumRap.getDiaChi());
			cumRapChieuHeThongRapDTO.setMaCumRap(cumRap.getMaCumRap());
			cumRapChieuHeThongRapDTO.setTenCumRap(cumRap.getTenCumRap());
			cumRapChieuHeThongRapList.add(cumRapChieuHeThongRapDTO);
		}

		Set<Rap> raps = new HashSet<Rap>();
		for (CumRapChieuHeThongRapDTO o : cumRapChieuHeThongRapList) {
			for (Rap r : rapRepository.findByCumRap(cumRapRepository.findById(o.getMaCumRap()).get()).get()) {
				raps.add(r);
			}
		}

		List<LichChieu> lichChieus = new ArrayList<LichChieu>();

		for (Rap o : raps) {
			if (o.getLichChieuRaps() != null) {
				for (LichChieu lc : o.getLichChieuRaps()) {
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
					lichChieuDTO.setMaRap(lc.getRapLichChieu().getMaRap());
					lichChieuDTO.setTenRap(lc.getRapLichChieu().getTenRap());
					lichChieuList.add(lichChieuDTO);
				}
			}
			phimChieuHeThongRapDTO.setMaPhim(p.getMaPhim());
			phimChieuHeThongRapDTO.setTenPhim(p.getTenPhim());
			phimChieuHeThongRapDTO.setHinhAnh(p.getHinhAnh());
			phimChieuHeThongRapDTO.setLstLichChieuTheoPhim(lichChieuList);
			phimChieuHeThongRapDTOs.add(phimChieuHeThongRapDTO);
		}

		cumRapChieuHeThongRapDTO.setDanhSachPhim(phimChieuHeThongRapDTOs);
		
		List<CumRapChieuHeThongRapDTO> cumRapChieuHeThongRapList1 = new LinkedList<CumRapChieuHeThongRapDTO>();
		for (CumRapChieuHeThongRapDTO o : cumRapChieuHeThongRapList) {
			if (o.getDanhSachPhim() != null) {
				cumRapChieuHeThongRapList1.add(o);
			}
		}
		thongTinLichChieuHeThongRapDTO.setListCumRap(cumRapChieuHeThongRapList1);

		return thongTinLichChieuHeThongRapDTO;
	}
	
//	public Object searchThongTinLichChieuHeThongRap() {
//		ThongTinLichChieuHeThongRapDTO thongTinLichChieuHeThongRapDTO = new ThongTinLichChieuHeThongRapDTO();
//		Optional<HeThongRap> heThongRap = heThongRapRepository.findById(maHeThongRap);
//		if (!heThongRap.isPresent()) {
//			throw new InvalidDataException("Mã hệ thống rạp không tồn tại!");
//		} else {
//			thongTinLichChieuHeThongRapDTO = LichChieuMapper.INSTANCE
//					.fromEntityToThongTinLichChieuHeThongRapDTO(heThongRap.get());
//		}
//
//		Optional<List<CumRap>> cumRaps = cumRapRepository.findByHeThongRap(heThongRap.get());
//		List<CumRapChieuHeThongRapDTO> cumRapChieuHeThongRapList = new ArrayList<CumRapChieuHeThongRapDTO>();
//		CumRapChieuHeThongRapDTO cumRapChieuHeThongRapDTO = null;
//
//		for (CumRap cumRap : cumRaps.get()) {
//			cumRapChieuHeThongRapDTO = new CumRapChieuHeThongRapDTO();
//			cumRapChieuHeThongRapDTO.setDiaChi(cumRap.getDiaChi());
//			cumRapChieuHeThongRapDTO.setMaCumRap(cumRap.getMaCumRap());
//			cumRapChieuHeThongRapDTO.setTenCumRap(cumRap.getTenCumRap());
//			cumRapChieuHeThongRapList.add(cumRapChieuHeThongRapDTO);
//		}
//
//		Set<Rap> raps = new HashSet<Rap>();
//		for (CumRapChieuHeThongRapDTO o : cumRapChieuHeThongRapList) {
//			for (Rap r : rapRepository.findByCumRap(cumRapRepository.findById(o.getMaCumRap()).get()).get()) {
//				raps.add(r);
//			}
//		}
//
//		List<LichChieu> lichChieus = new ArrayList<LichChieu>();
//
//		for (Rap o : raps) {
//			if (o.getLichChieuRaps() != null) {
//				for (LichChieu lc : o.getLichChieuRaps()) {
//					lichChieus.add(lc);
//				}
//			}
//		}
//
//		Set<Phim> phims = new HashSet<Phim>();
//		for (LichChieu o : lichChieus) {
//			phims.add(o.getPhim());
//		}
//
//		List<PhimChieuHeThongRapDTO> phimChieuHeThongRapDTOs = new LinkedList<PhimChieuHeThongRapDTO>();
//		PhimChieuHeThongRapDTO phimChieuHeThongRapDTO = null;
//		LichChieuDTO lichChieuDTO = null;
//		List<LichChieuDTO> lichChieuList = null;
//		for (Phim p : phims) {
//			phimChieuHeThongRapDTO = new PhimChieuHeThongRapDTO();
//			lichChieuList = new LinkedList<LichChieuDTO>();
//			for (LichChieu lc : lichChieus) {
//				if (p.equals(lc.getPhim())) {
//					lichChieuDTO = new LichChieuDTO();
//					lichChieuDTO = LichChieuMapper.INSTANCE.fromEntityToLichChieuDTO(lc);
//					lichChieuDTO.setMaRap(lc.getRapLichChieu().getMaRap());
//					lichChieuDTO.setTenRap(lc.getRapLichChieu().getTenRap());
//					lichChieuList.add(lichChieuDTO);
//				}
//			}
//			phimChieuHeThongRapDTO.setMaPhim(p.getMaPhim());
//			phimChieuHeThongRapDTO.setTenPhim(p.getTenPhim());
//			phimChieuHeThongRapDTO.setHinhAnh(p.getHinhAnh());
//			phimChieuHeThongRapDTO.setLstLichChieuTheoPhim(lichChieuList);
//			phimChieuHeThongRapDTOs.add(phimChieuHeThongRapDTO);
//		}
//
//		cumRapChieuHeThongRapDTO.setDanhSachPhim(phimChieuHeThongRapDTOs);
//		
//		List<CumRapChieuHeThongRapDTO> cumRapChieuHeThongRapList1 = new LinkedList<CumRapChieuHeThongRapDTO>();
//		for (CumRapChieuHeThongRapDTO o : cumRapChieuHeThongRapList) {
//			if (o.getDanhSachPhim() != null) {
//				cumRapChieuHeThongRapList1.add(o);
//			}
//		}
//		thongTinLichChieuHeThongRapDTO.setListCumRap(cumRapChieuHeThongRapList1);
//
//		return thongTinLichChieuHeThongRapDTO;
//	}

}
