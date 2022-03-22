package cybersoft.javabackend.moviejava14.ghe.dto;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;

@Mapper
public interface GheMapper {
	
	GheMapper INSTANCE = Mappers.getMapper(GheMapper.class);
	
	GheDTO fromEntityToGheDTO (Ghe ghe);
	Ghe fromGheDTOToEntity (GheDTO dto);
	
	Ghe fromCreateGheDTOtoEntity(CreateGheDTO dto);

}
