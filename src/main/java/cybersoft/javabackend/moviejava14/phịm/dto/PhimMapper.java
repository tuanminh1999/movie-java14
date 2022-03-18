package cybersoft.javabackend.moviejava14.phịm.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.phịm.entity.Phim;


@Mapper
public interface PhimMapper {
	
	public PhimMapper INSTANCE = Mappers.getMapper(PhimMapper.class);
	
	PhimDTO fromEntityToPhimDTO(Phim phim);
	Phim fromPhimDTOToEntity(PhimDTO phimDTO);
	
}
