package cybersoft.javabackend.moviejava14.loaiNguoiDung.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungMapper;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.repositoty.LoaiNguoiDungRepository;

@Service
public class LoaiNguoiDungServiceImpl implements LoaiNguoiDungService {
	
	private LoaiNguoiDungRepository loaiNguoiDungRepositoy;
	public LoaiNguoiDungServiceImpl(LoaiNguoiDungRepository loaiNguoiDungRepositoy) {
		this.loaiNguoiDungRepositoy = loaiNguoiDungRepositoy;
	}

	@Override
	public Optional<LoaiNguoiDungDTO> findByTenLoaiNguoiDung(String tenLoaiNguoiDung) {
		Optional<LoaiNguoiDung> loaiNguoiDung = loaiNguoiDungRepositoy.findByTenLoaiNguoiDung(tenLoaiNguoiDung);
		if (!loaiNguoiDung.isPresent()) {
			return null;
		}
        
		return Optional.ofNullable(LoaiNguoiDungMapper.INSTANCE.fromEntityToLoaiNguoiDungDTO(loaiNguoiDung.get()));
	}

	@Override
	public List<LoaiNguoiDungDTO> findAll() {
		List<LoaiNguoiDung> loaiNguoiDungs =  loaiNguoiDungRepositoy.findAll();
		
		return loaiNguoiDungs.stream()
				.map(o -> LoaiNguoiDungMapper.INSTANCE.fromEntityToLoaiNguoiDungDTO(o))
				.collect(Collectors.toList());
	}

}
