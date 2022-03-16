package cybersoft.javabackend.moviejava14.heThongRap.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;

@Mapper
public interface HeThongRapMapper {
	HeThongRapMapper INSTANCE = Mappers.getMapper(HeThongRapMapper.class);
	
	HeThongRapDTO fromEntityToHeThongRapDTO (HeThongRap heThongRap);
	HeThongRap fromHeThongRapDTOToEntity (HeThongRapDTO dto);
	
	HeThongRap fromCreateHeThongRapDTOtoEntity (CreateHeThongRapDTO dto);
}
