package cybersoft.javabackend.moviejava14.loaiGhe.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;

@Mapper
public interface LoaiGheMapper {
	
LoaiGheMapper INSTANCE = Mappers.getMapper(LoaiGheMapper.class);
	
	LoaiGheDTO fromEntityToLoaiGheDTO (LoaiGhe loaiGhe);
	LoaiGhe fromLoaiGheDTOToEntity (LoaiGheDTO dto);

}
