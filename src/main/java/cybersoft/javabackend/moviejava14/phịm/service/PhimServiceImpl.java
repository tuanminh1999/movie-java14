package cybersoft.javabackend.moviejava14.phịm.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.dto.PageDTO;
import cybersoft.javabackend.moviejava14.common.exeption.DateFormatException;
import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.common.utils.DateFormatter;
import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import cybersoft.javabackend.moviejava14.phịm.dto.CreatePhimDTO;
import cybersoft.javabackend.moviejava14.phịm.dto.LichChieuPhimDTO;
import cybersoft.javabackend.moviejava14.phịm.dto.PhimDTO;
import cybersoft.javabackend.moviejava14.phịm.dto.PhimMapper;
import cybersoft.javabackend.moviejava14.phịm.dto.ThongTinPhimDTO;
import cybersoft.javabackend.moviejava14.phịm.dto.ThongTinRapDTO;
import cybersoft.javabackend.moviejava14.phịm.dto.UpdatePhimDTO;
import cybersoft.javabackend.moviejava14.phịm.entity.Phim;
import cybersoft.javabackend.moviejava14.phịm.repository.PhimRepository;

@Service
public class PhimServiceImpl implements PhimService {

	private PhimRepository phimRepository;

	public PhimServiceImpl(PhimRepository phimRepository) {
		this.phimRepository = phimRepository;
	}

	@Override
	public List<PhimDTO> searchPhim(String tuKhoa, Pageable pageable) {
		List<Phim> phims = null;
		if (tuKhoa != null && pageable == null) {
			phims = phimRepository.findByTenPhimContainingOrBiDanhContaining(tuKhoa, tuKhoa, null);
		} else if (tuKhoa == null && pageable != null) {
			phims = phimRepository.findAllPaging(pageable);
		} else if (tuKhoa != null && pageable != null) {
			phims = phimRepository.findByTenPhimContainingOrBiDanhContaining(tuKhoa, tuKhoa, pageable);
		} else {
			phims = phimRepository.findAll();
		}
		return phims.stream().map(p -> PhimMapper.INSTANCE.fromEntityToPhimDTO(p)).collect(Collectors.toList());
	}

	@Override
	public PageDTO<PhimDTO> searchPhimPaging(String tuKhoa, Pageable pageable) {
		List<PhimDTO> phims = searchPhim(tuKhoa, pageable);
		PageDTO<PhimDTO> page = new PageDTO<PhimDTO>();
		page.setCurrentPage(pageable.getPageNumber() + 1);
		page.setCount(phims.size());
		page.setTotalCount(searchPhim(tuKhoa, null).size());
		int totalPages = (int) Math.ceil((double) page.getTotalCount() / pageable.getPageSize());
		page.setTotalPages(totalPages);
		page.setItems(phims);
		return page;
	}

	@Override
	public PageDTO<PhimDTO> searchPhimByNgayKhoiChieuPaging(String tuNgay, String denNgay, Pageable pageable) {
		List<Phim> phims = null;
		Timestamp tuNgayT = null, denNgayT = null;
		int totalCounts = 0;
		if ((tuNgay == null || tuNgay.isBlank()) && (denNgay == null || denNgay.isBlank())) {
			return searchPhimPaging(null, pageable);
		} else if (tuNgay != null && (denNgay == null || denNgay.isBlank())) {
			tuNgayT = DateFormatter.convertStringToDate(tuNgay);
			if (tuNgayT == null) {
				throw new DateFormatException("Ngày không hợp lệ, Ngày có định dạng dd/MM/yyyy !");
			}
			phims = phimRepository.findByNgayKhoiChieuAfter(tuNgayT, pageable);
			totalCounts = phimRepository.findByNgayKhoiChieuAfter(tuNgayT, null).size();
		} else if ((tuNgay == null || tuNgay.isBlank()) && denNgay != null) {
			denNgayT = DateFormatter.convertStringToDate(denNgay);
			if (denNgayT == null) {
				throw new DateFormatException("Ngày không hợp lệ, Ngày có định dạng dd/MM/yyyy !");
			}
			phims = phimRepository.findByNgayKhoiChieuBefore(denNgayT, pageable);
			totalCounts = phimRepository.findByNgayKhoiChieuBefore(denNgayT, null).size();
		} else {
			tuNgayT = DateFormatter.convertStringToDate(tuNgay);
			denNgayT = DateFormatter.convertStringToDate(denNgay);
			if (tuNgayT == null || denNgayT == null) {
				throw new DateFormatException("Ngày không hợp lệ, Ngày có định dạng dd/MM/yyyy !");
			}
			phims = phimRepository.findByNgayKhoiChieuBetween(tuNgayT, denNgayT, pageable);
			totalCounts = phimRepository.findByNgayKhoiChieuBetween(tuNgayT, denNgayT, null).size();
		}

		PageDTO<PhimDTO> page = new PageDTO<PhimDTO>();
		page.setCurrentPage(pageable.getPageNumber() + 1);
		page.setCount(phims.size());
		page.setTotalCount(totalCounts);
		int totalPages = (int) Math.ceil((double) page.getTotalCount() / pageable.getPageSize());
		page.setTotalPages(totalPages);
		List<PhimDTO> phimDTOs = phims.stream().map(p -> PhimMapper.INSTANCE.fromEntityToPhimDTO(p))
				.collect(Collectors.toList());
		page.setItems(phimDTOs);
		return page;
	}
	
	@Override
	public PhimDTO create(CreatePhimDTO dto, String fileName) {
		Phim phim = new Phim();
	 	phim.setTenPhim( dto.getTenPhim() );
        phim.setBiDanh( dto.getBiDanh() );
        phim.setTrailer( dto.getTrailer() );
        phim.setHinhAnh(fileName);
        phim.setMoTa( dto.getMoTa() );
        phim.setNgayKhoiChieu( DateFormatter.convertStringToDate(dto.getNgayKhoiChieu()) );
        phim.setDanhGia( dto.getDanhGia() );
		Phim createPhim = phimRepository.save(phim);
		PhimDTO phimDTO = PhimMapper.INSTANCE.fromEntityToPhimDTO(createPhim);
		return phimDTO;
	}

	@Override
	public PhimDTO update(UpdatePhimDTO dto, String fileName) {
		Optional<Phim> phimOpt = phimRepository.findById(dto.getMaPhim());
		if(!phimOpt.isPresent()) {
			throw new InvalidDataException("Phim không tồn tại");
		}
		
		Phim phim = phimOpt.get();
		if(!phim.getTenPhim().equalsIgnoreCase(dto.getTenPhim())) {
			if(phimRepository.findByTenPhim(dto.getTenPhim()).isPresent()) {
				throw new InvalidDataException("Tên phim đã tồn tại");
			}
			phim.setTenPhim(dto.getTenPhim());
		}
		
		if(!phim.getBiDanh().equalsIgnoreCase(dto.getBiDanh())) {
			if(phimRepository.findByBiDanh(dto.getBiDanh()).isPresent()) {
				throw new InvalidDataException("Bí danh phim đã tồn tại");
			}
			phim.setBiDanh(dto.getBiDanh());
		}
		
		phim.setTrailer( dto.getTrailer() );
        phim.setHinhAnh(fileName);
        phim.setMoTa( dto.getMoTa() );
        phim.setNgayKhoiChieu( DateFormatter.convertStringToDate(dto.getNgayKhoiChieu()) );
        phim.setDanhGia( dto.getDanhGia() );
        
		Phim createPhim = phimRepository.save(phim);
		
		PhimDTO phimDTO = PhimMapper.INSTANCE.fromEntityToPhimDTO(createPhim);
		return phimDTO;
	}

	@Override
	public void delete(int maPhim) {
		Optional<Phim> phimOpt = phimRepository.findById(maPhim);

		if (!phimOpt.isPresent()) {
			throw new InvalidDataException("Id phim không tồn tại");
		}

		phimRepository.delete(phimOpt.get());
	}

	@Override
	public ThongTinPhimDTO getPhimByMaPhim(int maPhim) {
		Optional<Phim> phimOpt = phimRepository.findById(maPhim);
		if(!phimOpt.isPresent()) {
			throw new InvalidDataException("Mã phim không tồn tại");
		}
		Phim phim = phimOpt.get();
		
		ThongTinPhimDTO thongTinPhimDTO = PhimMapper.INSTANCE.fromThongTinPhimDTOToEntity(phim);
		
		List<LichChieuPhimDTO> lichChieuPhimDTOs = new LinkedList<LichChieuPhimDTO>();
		for(LichChieu lc : phim.getLichChieuPhims()) {
			LichChieuPhimDTO lichChieuPhimDTO = new LichChieuPhimDTO();
			lichChieuPhimDTO.setMaLichChieu(lc.getMaLichChieu());
			lichChieuPhimDTO.setMaRap(lc.getRap().getMaRap());
			lichChieuPhimDTO.setMaPhim(lc.getPhim().getMaPhim());
			lichChieuPhimDTO.setNgayChieuGioChieu(lc.getNgayGioChieu());
			lichChieuPhimDTO.setGiaVe(lc.getGiaVe());
			lichChieuPhimDTO.setThoiLuong(lc.getThoiLuong());
			
			ThongTinRapDTO thongTinRapDTO = new ThongTinRapDTO();
			thongTinRapDTO.setMaRap(lc.getRap().getMaRap());
			thongTinRapDTO.setTenRap(lc.getRap().getTenRap());
			thongTinRapDTO.setMaCumRap(lc.getRap().getCumRap().getMaCumRap());
			thongTinRapDTO.setTenCumRap(lc.getRap().getCumRap().getTenCumRap());
			thongTinRapDTO.setMaHeThongRap(lc.getRap().getCumRap().getHeThongRap().getMaHeThongRap());
			thongTinRapDTO.setTenHeThongRap(lc.getRap().getCumRap().getHeThongRap().getTenHeThongRap());
			
			lichChieuPhimDTO.setThongTinRap(thongTinRapDTO);
			lichChieuPhimDTOs.add(lichChieuPhimDTO);
		}
		thongTinPhimDTO.setLichChieu(lichChieuPhimDTOs);
		
		return thongTinPhimDTO;
	}

}
