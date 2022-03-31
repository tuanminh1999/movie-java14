package cybersoft.javabackend.moviejava14.lichchieu.service;

import cybersoft.javabackend.moviejava14.lichchieu.dto.CreateLichChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.LichChieuDTO;

public interface LichChieuService {

	LichChieuDTO create(CreateLichChieuDTO dto);

	Object searchThongTinLichChieu(int maPhim);
	
	Object searchThongTinLichChieuHeThongRap(String maHeThongRap);
	
}
