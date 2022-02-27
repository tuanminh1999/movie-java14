package cybersoft.javabackend.moviejava14.loaiNguoiDung.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.LoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.repositoty.LoaiNguoiDungRepository;

@Service
public class LoaiNguoiDungServiceImpl implements LoaiNguoiDungService {
	
	private LoaiNguoiDungRepository loaiNguoiDungRepositoy;

	@Override
	public Optional<LoaiNguoiDungDTO> findByTenLoaiNguoiDung(String tenLoaiNguoiDung) {
		Optional<LoaiNguoiDung> loaiNguoiDung = loaiNguoiDungRepositoy.findByTenLoaiNguoiDung(tenLoaiNguoiDung);
		if (!loaiNguoiDung.isPresent()) {
			return null;
		}

        LoaiNguoiDungDTO loaiNguoiDungDTO = new LoaiNguoiDungDTO();

        loaiNguoiDungDTO.setId( loaiNguoiDungDTO.getId() );
        loaiNguoiDungDTO.setCreatedBy( loaiNguoiDungDTO.getCreatedBy() );
        loaiNguoiDungDTO.setCreatedDate( loaiNguoiDungDTO.getCreatedDate() );
        loaiNguoiDungDTO.setModifiedBy( loaiNguoiDungDTO.getModifiedBy() );
        loaiNguoiDungDTO.setModifiedDate( loaiNguoiDungDTO.getModifiedDate() );
        loaiNguoiDungDTO.setTenLoaiNguoiDung( loaiNguoiDungDTO.getTenLoaiNguoiDung() );
        
		return Optional.ofNullable(loaiNguoiDungDTO);
	}

}
