package cybersoft.javabackend.moviejava14.nguoiDung.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;

@Mapper
public interface NguoiDungMapper {
	NguoiDungMapper INSTANCE = Mappers.getMapper(NguoiDungMapper.class);
	
	NguoiDungDTO fromEntityToNguoiDungDTO (NguoiDung nguoiDung);
	NguoiDung fromNguoiDungDTOToEntity (NguoiDungDTO dto);
	
	NguoiDung fromCreateNguoiDungDTOToEntity (CreateNguoiDungDTO dto);
	
}
