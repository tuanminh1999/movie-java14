package cybersoft.javabackend.moviejava14.rap.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.rap.entity.Rap;

@Mapper
public interface RapMapper {
	
	RapMapper INSTANCE = Mappers.getMapper(RapMapper.class);
	
	RapDTO fromEntitytoRapDTO (Rap rap);
	Rap fromRapDTOtoEntity (RapDTO dto);
	
	Rap fromCreateRapDTOtoEntity (CreateRapDTO dto);
}
