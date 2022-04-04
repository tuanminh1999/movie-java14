package cybersoft.javabackend.moviejava14.lichchieu.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import cybersoft.javabackend.moviejava14.phịm.entity.Phim;

@Mapper
public interface LichChieuMapper {
	
	LichChieuMapper INSTANCE = Mappers.getMapper(LichChieuMapper.class);
	
	LichChieuDTO fromEntityToLichChieuDTO (LichChieu lichChieu);
	LichChieu fromLichChieuDTOToEntity (LichChieuDTO dto);
		
	ThongTinLichChieuPhimDTO fromEntityToThongTinLichChieuDTO(Phim phim);
	
	ThongTinLichChieuHeThongRapDTO fromEntityToThongTinLichChieuHeThongRapDTO(HeThongRap heThongRap);
	
}
