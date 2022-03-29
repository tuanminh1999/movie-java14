package cybersoft.javabackend.moviejava14.lichchieu.service;

import cybersoft.javabackend.moviejava14.lichchieu.dto.CreateLichChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.LichChieuDTO;
import cybersoft.javabackend.moviejava14.lichchieu.dto.ThongTinLichChieuPhimDTO;

public interface LichChieuService {

	LichChieuDTO create(CreateLichChieuDTO dto);

	Object searchThongTinLichChieu(int maPhim);
	
}
