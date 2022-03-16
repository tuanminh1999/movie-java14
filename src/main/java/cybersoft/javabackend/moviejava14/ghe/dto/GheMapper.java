package cybersoft.javabackend.moviejava14.ghe.dto;

import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheMapper;
import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;

public interface GheMapper {
	
LoaiGheMapper INSTANCE = Mappers.getMapper(LoaiGheMapper.class);
	
	LoaiGheDTO fromEntityToLoaiGheDTO (LoaiGhe loaiGhe);
	LoaiGhe fromLoaiGheDTOToEntity (LoaiGheDTO dto);
	LoaiGhe fromCreateLoaiGheDTOtoEntity (CreateLoaiGheDTO dto);


}
