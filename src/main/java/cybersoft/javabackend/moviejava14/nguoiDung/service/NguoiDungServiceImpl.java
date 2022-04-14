package cybersoft.javabackend.moviejava14.nguoiDung.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.commones.dto.PageDTO;
import cybersoft.javabackend.moviejava14.commones.exeption.ExistedDataException;
import cybersoft.javabackend.moviejava14.commones.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.datVe.entity.DatVe;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.repositoty.LoaiNguoiDungRepository;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.DanhSachGheNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungMapper;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.ThongTinDatVeDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.ThongTinTaiKhoanDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.UpdateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.repository.NguoiDungRepository;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	private NguoiDungRepository nguoiDungRepository;
	private LoaiNguoiDungRepository loaiNguoiDungRepository;
	private PasswordEncoder encoder;
	

	public NguoiDungServiceImpl(NguoiDungRepository nguoiDungRepository, PasswordEncoder encoder,
			LoaiNguoiDungRepository loaiNguoiDungRepository) {
		this.nguoiDungRepository = nguoiDungRepository;
		this.loaiNguoiDungRepository = loaiNguoiDungRepository;
		this.encoder = encoder;
	}

	@Override
	public ThongTinTaiKhoanDTO getThongTinTaiKhoanByTaiKhoan(String taiKhoan) {
		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByTaiKhoan(taiKhoan);

		if (!nguoiDungOpt.isPresent()) {
			return null;
		}

		NguoiDung nd = nguoiDungOpt.get();

		ThongTinTaiKhoanDTO thongTinTaiKhoanDTO = new ThongTinTaiKhoanDTO();
		thongTinTaiKhoanDTO.setTaiKhoan(nd.getTaiKhoan());
		thongTinTaiKhoanDTO.setMatKhau(nd.getMatKhau());
		thongTinTaiKhoanDTO.setHoTen(nd.getHoTen());
		thongTinTaiKhoanDTO.setEmail(nd.getEmail());
		thongTinTaiKhoanDTO.setSoDT(nd.getSoDt());
		thongTinTaiKhoanDTO.setLoaiNguoiDung(nd.getLoaiNguoiDung().getTenLoai());

		List<ThongTinDatVeDTO> thongTinDatVeDTOs = new LinkedList<ThongTinDatVeDTO>();
		ThongTinDatVeDTO thongTinDatVeDTO = null;
		List<DanhSachGheNguoiDungDTO> danhSachGheNguoiDungDTOs = null;
		for (DatVe o : nd.getDateVes()) {
			danhSachGheNguoiDungDTOs = new LinkedList<DanhSachGheNguoiDungDTO>();
			thongTinDatVeDTO = new ThongTinDatVeDTO();
			DanhSachGheNguoiDungDTO danhSachGheNguoiDungDTO = new DanhSachGheNguoiDungDTO();
			danhSachGheNguoiDungDTO.setMaHeThongRap(
					o.getMaLichChieu().getRap().getCumRap().getHeThongRap().getMaHeThongRap());
			danhSachGheNguoiDungDTO.setTenHeThongRap(
					o.getMaLichChieu().getRap().getCumRap().getHeThongRap().getTenHeThongRap());
			danhSachGheNguoiDungDTO.setMaCumRap(o.getMaLichChieu().getRap().getCumRap().getMaCumRap());
			danhSachGheNguoiDungDTO.setTenCumRap(o.getMaLichChieu().getRap().getCumRap().getTenCumRap());
			danhSachGheNguoiDungDTO.setMaRap(o.getMaLichChieu().getRap().getMaRap());
			danhSachGheNguoiDungDTO.setTenRap(o.getMaLichChieu().getRap().getTenRap());
			danhSachGheNguoiDungDTO.setMaGhe(o.getMaGhe().getMaGhe());
			danhSachGheNguoiDungDTO.setTenGhe(o.getMaGhe().getTenGhe());
			danhSachGheNguoiDungDTOs.add(danhSachGheNguoiDungDTO);
			thongTinDatVeDTO.setMaVe(o.getId());
			thongTinDatVeDTO.setNgayDat(o.getNgayDat());
			thongTinDatVeDTO.setTenPhim(o.getMaLichChieu().getPhim().getTenPhim());
			thongTinDatVeDTO.setGiaVe(o.getGiaVe());
			thongTinDatVeDTO.setThoiLuongPhim(o.getMaLichChieu().getThoiLuong());
			thongTinDatVeDTO.setDanhSachGhe(danhSachGheNguoiDungDTOs);
			thongTinDatVeDTOs.add(thongTinDatVeDTO);
		}
		thongTinTaiKhoanDTO.setThongTinDatVe(thongTinDatVeDTOs);
		return thongTinTaiKhoanDTO;

	}

	@Override
	public NguoiDungDTO create(CreateNguoiDungDTO dto) {
		NguoiDung nguoiDung = NguoiDungMapper.INSTANCE.fromCreateNguoiDungDTOToEntity(dto);
		nguoiDung.setMatKhau(encoder.encode(dto.getMatKhau()));
		
		Optional<LoaiNguoiDung> loaiNguoiDungOpt = loaiNguoiDungRepository.findById(dto.getMaLoaiNguoiDung());
		if (!loaiNguoiDungOpt.isPresent()) {
			throw new InvalidDataException("Loại người dùng không tồn tại. ");
		} else {
			nguoiDung.setLoaiNguoiDung(loaiNguoiDungOpt.get());
		}
		NguoiDung createNguoiDung = nguoiDungRepository.save(nguoiDung);
		NguoiDungDTO nguoiDungDTO = NguoiDungMapper.INSTANCE.fromEntityToNguoiDungDTO(createNguoiDung);
		nguoiDungDTO.setMaLoaiNguoiDung(createNguoiDung.getLoaiNguoiDung().getMaLoaiNguoiDung());
		return nguoiDungDTO;
	}

	@Override
	public NguoiDungDTO update(UpdateNguoiDungDTO dto) {

		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByTaiKhoan(dto.getTaiKhoan());

		if (!nguoiDungOpt.isPresent()) {
			throw new InvalidDataException("Tài khoản người dùng không tồn tại. ");
		}

		NguoiDung nguoiDung = nguoiDungOpt.get();

		if (!nguoiDung.getEmail().equals(dto.getEmail())) {
			if (nguoiDungRepository.findByEmail(dto.getEmail()).isPresent()) {
				throw new ExistedDataException("Email người dùng đã tồn tại. ");
			}
			nguoiDung.setEmail(dto.getEmail());
		}

		if (!nguoiDung.getSoDt().equals(dto.getSoDt())) {
			if (nguoiDungRepository.findBySoDt(dto.getSoDt()).isPresent()) {
				throw new ExistedDataException("Số điện thoại người dùng đã tồn tại. ");
			}
			nguoiDung.setSoDt(dto.getSoDt());
		}

		nguoiDung.setHoTen(dto.getHoTen());

		if (!nguoiDung.getLoaiNguoiDung().getMaLoaiNguoiDung().equals(dto.getMaLoaiNguoiDung())) {
			Optional<LoaiNguoiDung> loaiNguoiDung = loaiNguoiDungRepository.findById(dto.getMaLoaiNguoiDung());
			if (!loaiNguoiDung.isPresent()) {
				throw new InvalidDataException("Loại người dùng không tồn tại. ");
			} else {
				nguoiDung.setLoaiNguoiDung(loaiNguoiDung.get());
			}
		}

		NguoiDung updatedNguoiDung = nguoiDungRepository.save(nguoiDung);

		NguoiDungDTO nguoiDungDTO = NguoiDungMapper.INSTANCE.fromEntityToNguoiDungDTO(updatedNguoiDung);
		nguoiDungDTO.setMaLoaiNguoiDung(updatedNguoiDung.getLoaiNguoiDung().getMaLoaiNguoiDung());
		return nguoiDungDTO;
	}

	@Override
	public void delete(String taiKhoan) {
		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByTaiKhoan(taiKhoan);

		if (!nguoiDungOpt.isPresent()) {
			throw new InvalidDataException("Tài khoản người dùng không tồn tại. ");
		}

		nguoiDungRepository.delete(nguoiDungOpt.get());
	}

	@Override
	public List<NguoiDungDTO> searchNguoiDung(String tuKhoa, Pageable pageable) {
		List<NguoiDung> nguoiDungs = null;
		List<NguoiDungDTO> nguoiDungDTOs = new LinkedList<NguoiDungDTO>();

		if (tuKhoa != null && pageable == null) {
			nguoiDungs = nguoiDungRepository.findByTaiKhoanContainingOrHoTenContaining(tuKhoa, tuKhoa);
		} else if (tuKhoa == null && pageable != null) {
			nguoiDungs = nguoiDungRepository.findAllPaging(pageable);
		} else if (tuKhoa != null && pageable != null) {
			nguoiDungs = nguoiDungRepository.findByTaiKhoanContainingOrHoTenContaining(tuKhoa, tuKhoa, pageable);
		} else {
			nguoiDungs = nguoiDungRepository.findAll();
		}

		for (NguoiDung o : nguoiDungs) {
			NguoiDungDTO nd = NguoiDungMapper.INSTANCE.fromEntityToNguoiDungDTO(o);
			nd.setMaLoaiNguoiDung(o.getLoaiNguoiDung().getMaLoaiNguoiDung());
			nguoiDungDTOs.add(nd);
		}
		return nguoiDungDTOs;
	}

	@Override
	public PageDTO<NguoiDungDTO> searchNguoiDungPaging(String tuKhoa, Pageable pageable) {
		List<NguoiDungDTO> nguoiDungs = searchNguoiDung(tuKhoa, pageable);
		PageDTO<NguoiDungDTO> page = new PageDTO<NguoiDungDTO>();
		page.setCurrentPage(pageable.getPageNumber() + 1);
		page.setCount(nguoiDungs.size());
		page.setTotalCount(searchNguoiDung(tuKhoa, null).size());
		int totalPages = (int) Math.ceil((double) page.getTotalCount() / pageable.getPageSize());
		page.setTotalPages(totalPages);
		page.setItems(nguoiDungs);
		return page;
	}

}
