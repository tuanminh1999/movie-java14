package cybersoft.javabackend.moviejava14.dtos.cinemas;


import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CumRapMapper {
	CumRapMapper INSTANCE = Mappers.getMapper(CumRapMapper.class);
	
	CumRapDTO fromEntityToCumRapDTO (CumRap cumRap);
	CumRap fromCumRapDTOToEntity (CumRapDTO dto);
	
	CumRap fromCreateCumRapDTOtoEntity (CreateCumRapDTO dto);
	
}


