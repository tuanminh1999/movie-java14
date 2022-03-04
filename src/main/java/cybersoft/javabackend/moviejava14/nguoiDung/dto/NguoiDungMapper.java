package cybersoft.javabackend.moviejava14.nguoiDung.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;

@Mapper
public interface NguoiDungMapper {
	NguoiDungMapper INSTANCE = Mappers.getMapper(NguoiDungMapper.class);
	
	NguoiDungDTO fromEntityToLoaiNguoiDungDTO (NguoiDung nguoiDung);
	LoaiNguoiDung fromLoaiNguoiDungDTOToEntity (NguoiDungDTO dto);
	
	LoaiNguoiDung fromCreateLoaiNguoiDungDTOtoEntity (CreateNguoiDungDTO dto);
	
}
