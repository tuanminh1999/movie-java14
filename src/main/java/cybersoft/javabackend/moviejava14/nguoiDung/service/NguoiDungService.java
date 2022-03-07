package cybersoft.javabackend.moviejava14.nguoiDung.service;

import java.util.List;

import javax.validation.Valid;

import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;

public interface NguoiDungService {

	List<NguoiDungDTO> findAll();

	NguoiDungDTO create(@Valid CreateNguoiDungDTO dto);

}
