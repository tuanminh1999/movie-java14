package cybersoft.javabackend.moviejava14.nguoiDung.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungMapper;
import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.repository.NguoiDungRepository;

@Service
public class NguoiDungServiceImpl implements NguoiDungService{

	private NguoiDungRepository nguoiDungRepository;
	private PasswordEncoder encoder;

	public NguoiDungServiceImpl(NguoiDungRepository nguoiDungRepository, PasswordEncoder encoder) {
		this.nguoiDungRepository = nguoiDungRepository;
		this.encoder = encoder;
	}
	
	@Override
	public List<NguoiDungDTO> findAll() {
		List<NguoiDung> nguoiDungs = nguoiDungRepository.findAll();
		return nguoiDungs.stream().map(o -> NguoiDungMapper.INSTANCE.fromEntityToLoaiNguoiDungDTO(o))
				.collect(Collectors.toList());
	}

	@Override
	public NguoiDungDTO create(CreateNguoiDungDTO dto) {
		NguoiDung nguoiDung = NguoiDungMapper.INSTANCE.fromCreateLoaiNguoiDungDTOtoEntity(dto);
		nguoiDung.setMatKhau(encoder.encode(dto.getMatKhau()));
		NguoiDung createNguoiDung = nguoiDungRepository.save(nguoiDung);
		return NguoiDungMapper.INSTANCE.fromEntityToLoaiNguoiDungDTO(createNguoiDung);
	}

}
