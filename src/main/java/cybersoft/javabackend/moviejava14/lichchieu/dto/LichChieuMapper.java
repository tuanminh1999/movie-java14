package cybersoft.javabackend.moviejava14.lichchieu.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;

@Mapper
public interface LichChieuMapper {
	
	LichChieuMapper INSTANCE = Mappers.getMapper(LichChieuMapper.class);
	
	LichChieuDTO fromEntityToLichChieuDTO (LichChieu lichChieu);
	LichChieu fromLichChieuDTOToEntity (LichChieuDTO dto);
	
	LichChieu fromCreateLichChieuDTOToEntity (CreateLichChieuDTO dto);
	
}
