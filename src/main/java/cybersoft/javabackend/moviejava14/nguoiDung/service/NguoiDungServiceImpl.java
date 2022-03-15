package cybersoft.javabackend.moviejava14.nguoiDung.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.repositoty.LoaiNguoiDungRepository;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungMapper;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungProjection;
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
	public List<NguoiDungProjection> findAllDTO() {
		return nguoiDungRepository.findAllDTO();

	}

	@Override
	public Optional<NguoiDungDTO> getNguoiDungByEmail(String email) {
		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByEmail(email);

		if (!nguoiDungOpt.isPresent()) {
			return null;
		}

		return Optional.ofNullable(NguoiDungMapper.INSTANCE.fromEntityToNguoiDungDTO(nguoiDungOpt.get()));
	}

	@Override
	public Optional<NguoiDungDTO> getNguoiDungByTaiKhoan(String taiKhoan) {
		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByTaiKhoan(taiKhoan);

		if (!nguoiDungOpt.isPresent()) {
			return null;
		}

		return Optional.ofNullable(NguoiDungMapper.INSTANCE.fromEntityToNguoiDungDTO(nguoiDungOpt.get()));
	}

	@Override
	public Optional<NguoiDungDTO> getNguoiDungBySoDt(String soDt) {
		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findBySoDt(soDt);

		if (!nguoiDungOpt.isPresent()) {
			return null;
		}

		return Optional.ofNullable(NguoiDungMapper.INSTANCE.fromEntityToNguoiDungDTO(nguoiDungOpt.get()));
	}

	@Override
	public NguoiDungDTO create(CreateNguoiDungDTO dto) {
		NguoiDung nguoiDung = NguoiDungMapper.INSTANCE.fromCreateNguoiDungDTOtoEntity(dto);
		nguoiDung.setMatKhau(encoder.encode(dto.getMatKhau()));
		LoaiNguoiDung loaiNguoiDung = loaiNguoiDungRepository.findById(dto.getMaLoaiNguoiDung()).get();
		if (loaiNguoiDung == null) {
			throw new InvalidDataException("Loại người dùng không tồn tại");
		} else {
			nguoiDung.setLoaiNguoiDung(loaiNguoiDung);
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
			throw new InvalidDataException("Tài khoản người dùng không tồn tại");
		}

		NguoiDung nguoiDung = nguoiDungOpt.get();

		if (!nguoiDung.getEmail().equals(dto.getEmail())) {
			if (nguoiDungRepository.findByEmail(dto.getEmail()).isPresent()) {
				throw new InvalidDataException("Email người dùng đã tồn tại");
			}
			nguoiDung.setEmail(dto.getEmail());
		}

		if (!nguoiDung.getSoDt().equals(dto.getSoDt())) {
			if (nguoiDungRepository.findBySoDt(dto.getSoDt()).isPresent()) {
				throw new InvalidDataException("Số điện thoại người dùng đã tồn tại");
			}
			nguoiDung.setSoDt(dto.getSoDt());
		}

		nguoiDung.setHoTen(dto.getHoTen());

		if (!nguoiDung.getLoaiNguoiDung().getMaLoaiNguoiDung().equals(dto.getMaLoaiNguoiDung())) {
			Optional<LoaiNguoiDung> loaiNguoiDung = loaiNguoiDungRepository.findById(dto.getMaLoaiNguoiDung());
			if (!loaiNguoiDung.isPresent()) {
				throw new InvalidDataException("Loại người dùng không tồn tại");
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
		
		if(!nguoiDungOpt.isPresent()) {
			throw new InvalidDataException("Tài khoản người dùng không tồn tại");
		}
		
		nguoiDungRepository.delete(nguoiDungOpt.get());
	}

	@Override
	public List<NguoiDungProjection> searchNguoiDung(String tuKhoa) {
		if(tuKhoa == null) {
			return nguoiDungRepository.findAllDTO();
		}
		return nguoiDungRepository.searchByTaiKhoanOrHoTen(tuKhoa);
	}

	@Override
	public List<NguoiDungDTO> findAll(Pageable pageable) {
		List<NguoiDung> nguoiDungs = nguoiDungRepository.findAll(pageable).getContent();
		return nguoiDungs.stream().map(nd -> NguoiDungMapper.INSTANCE.fromEntityToNguoiDungDTO(nd)).collect(Collectors.toList());
	}

}
