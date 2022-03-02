package cybersoft.javabackend.moviejava14.loaiNguoiDung.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;

@Mapper
public interface LoaiNguoiDungMapper {
	LoaiNguoiDungMapper INSTANCE = Mappers.getMapper(LoaiNguoiDungMapper.class);
	
	LoaiNguoiDungDTO fromEntityToLoaiNguoiDungDTO (LoaiNguoiDung loaiNguoiDung);
	LoaiNguoiDung fromLoaiNguoiDungDTOToEntity (LoaiNguoiDungDTO dto);
	
	LoaiNguoiDung fromCreateLoaiNguoiDungDTOtoEntity (CreateLoaiNguoiDungDTO dto);
	
}
