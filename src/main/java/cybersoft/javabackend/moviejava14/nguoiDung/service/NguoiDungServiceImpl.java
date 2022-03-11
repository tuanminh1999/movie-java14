package cybersoft.javabackend.moviejava14.nguoiDung.service;

import java.util.List;
import java.util.Optional;

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
import cybersoft.javabackend.moviejava14.security.jwt.JwtUtils;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	private NguoiDungRepository nguoiDungRepository;
	private LoaiNguoiDungRepository loaiNguoiDungRepository;
	private PasswordEncoder encoder;
	private JwtUtils jwtUtils;

	public NguoiDungServiceImpl(NguoiDungRepository nguoiDungRepository, PasswordEncoder encoder, JwtUtils jwtUtils,
			LoaiNguoiDungRepository loaiNguoiDungRepository) {
		this.nguoiDungRepository = nguoiDungRepository;
		this.loaiNguoiDungRepository = loaiNguoiDungRepository;
		this.encoder = encoder;
		this.jwtUtils = jwtUtils;
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
		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByTaiKhoan(soDt);

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
	public NguoiDungDTO update(UpdateNguoiDungDTO dto, String token) {
		String taiKhoan = jwtUtils.getUsernameFromToken(token);

		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByTaiKhoan(taiKhoan);

		if (!nguoiDungOpt.isPresent()) {
			throw new InvalidDataException("Tài người dùng không tồn lại");
		}

		NguoiDung nguoiDung = nguoiDungOpt.get();

		if (!nguoiDung.getTaiKhoan().equals(dto.getTaiKhoan())) {
			if (nguoiDungRepository.findByTaiKhoan(dto.getTaiKhoan()).isPresent()) {
				throw new InvalidDataException("Tài khoản người dùng đã tồn tại");
			}
			nguoiDung.setTaiKhoan(dto.getTaiKhoan());
		}

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

}
