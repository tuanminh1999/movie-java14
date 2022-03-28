package cybersoft.javabackend.moviejava14.lichchieu.service;

import javax.validation.Valid;

import cybersoft.javabackend.moviejava14.lichchieu.dto.CreateLichChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.LichChieuDTO;

public interface LichChieuService {

	LichChieuDTO create(CreateLichChieuDTO dto);
	
}
