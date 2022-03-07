package cybersoft.javabackend.moviejava14.loaiNguoiDung.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungMapper;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.repositoty.LoaiNguoiDungRepository;

@Service
public class LoaiNguoiDungServiceImpl implements LoaiNguoiDungService {

	private LoaiNguoiDungRepository loaiNguoiDungRepositoy;

	public LoaiNguoiDungServiceImpl(LoaiNguoiDungRepository loaiNguoiDungRepositoy) {
		this.loaiNguoiDungRepositoy = loaiNguoiDungRepositoy;
	}
	
	@Override
	public Optional<LoaiNguoiDungDTO> getNguoiDungById(String id) {
		Optional<LoaiNguoiDung> loaiNguoiDungOpt = loaiNguoiDungRepositoy.findById(id);

		if (!loaiNguoiDungOpt.isPresent()) {
			return null;
		}
		
		return Optional.ofNullable(LoaiNguoiDungMapper.INSTANCE.fromEntityToLoaiNguoiDungDTO(loaiNguoiDungOpt.get()));
	}

	@Override
	public Optional<LoaiNguoiDungDTO> findByTenLoai(String tenLoai) {
		Optional<LoaiNguoiDung> loaiNguoiDungOpt = loaiNguoiDungRepositoy.findByTenLoai(tenLoai);
		if (!loaiNguoiDungOpt.isPresent()) {
			return null;
		}

		return Optional.ofNullable(LoaiNguoiDungMapper.INSTANCE.fromEntityToLoaiNguoiDungDTO(loaiNguoiDungOpt.get()));
	}

	@Override
	public List<LoaiNguoiDungDTO> findAll() {
		List<LoaiNguoiDung> loaiNguoiDungs = loaiNguoiDungRepositoy.findAll();

		return loaiNguoiDungs.stream().map(o -> LoaiNguoiDungMapper.INSTANCE.fromEntityToLoaiNguoiDungDTO(o))
				.collect(Collectors.toList());
	}

	@Override
	public LoaiNguoiDungDTO create(CreateLoaiNguoiDungDTO dto) {
		LoaiNguoiDung loaiNguoiDung = LoaiNguoiDungMapper.INSTANCE.fromCreateLoaiNguoiDungDTOtoEntity(dto);
		LoaiNguoiDung createLoaiNguoiDung = loaiNguoiDungRepositoy.save(loaiNguoiDung);
		return LoaiNguoiDungMapper.INSTANCE.fromEntityToLoaiNguoiDungDTO(createLoaiNguoiDung);
	}

	@Override
	public LoaiNguoiDungDTO update(UpdateLoaiNguoiDungDTO dto) {
		Optional<LoaiNguoiDung> loaiNguoiDungOpt = loaiNguoiDungRepositoy.findById(dto.getMaLoaiNguoiDung());
		
		if (!loaiNguoiDungOpt.isPresent()) {
			throw new InvalidDataException("Id loại người dùng không tồn lại");
		}
		
		LoaiNguoiDung loaiNguoiDung = loaiNguoiDungOpt.get();
		
		if(!loaiNguoiDung.getTenLoai().equals(dto.getTenLoai())) {
			if (loaiNguoiDungRepositoy.findByTenLoai(dto.getTenLoai()).isPresent()) {
				throw new InvalidDataException("Tên loại người dùng đã tồn tại");
			}
			loaiNguoiDung.setTenLoai(dto.getTenLoai());
		}
		
		LoaiNguoiDung updatedLoaiNguoiDung = loaiNguoiDungRepositoy.save(loaiNguoiDung);
		
		return LoaiNguoiDungMapper.INSTANCE.fromEntityToLoaiNguoiDungDTO(updatedLoaiNguoiDung);
	}

	@Override
	public void delete(String id) {
		Optional<LoaiNguoiDung> loaiNguoiDungOpt = loaiNguoiDungRepositoy.findById(id);
		
		if(!loaiNguoiDungOpt.isPresent()) {
			throw new InvalidDataException("Id loại người dùng không tồn tại");
		}
		
		loaiNguoiDungRepositoy.delete(loaiNguoiDungOpt.get());
	}

}
