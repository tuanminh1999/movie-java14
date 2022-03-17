package cybersoft.javabackend.moviejava14.ghe.dto;

import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.LoaiGheMapper;
import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;

public interface GheMapper {
	
GheMapper INSTANCE = Mappers.getMapper(GheMapper.class);
	
	GheDTO fromEntityToGheDTO (Ghe ghe);
	Ghe fromGheDTOToEntity (GheDTO dto);
	Ghe fromCreateGheDTOtoEntity (CreateGheDTO dto);


}
