package cybersoft.javabackend.moviejava14.cumRap.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;

@Mapper
public interface CumRapMapper {
	CumRapMapper INSTANCE = Mappers.getMapper(CumRapMapper.class);
	
	CumRapDTO fromEntityToCumRapDTO (CumRap cumRap);
	CumRap fromCumRapDTOToEntity (CumRapDTO dto);
	
	CumRap fromCreateCumRapDTOtoEntity (CreateCumRapDTO dto);
}
