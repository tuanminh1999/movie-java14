package cybersoft.javabackend.moviejava14.datVe.service;

import cybersoft.javabackend.moviejava14.datVe.dto.CreateDatVeDTO;

public interface DatVeService {

	boolean create(CreateDatVeDTO dto);

	Object getDatVe(int maLichChieu);
	
}
