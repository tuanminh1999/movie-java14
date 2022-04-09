package cybersoft.javabackend.moviejava14.phịm.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import cybersoft.javabackend.moviejava14.common.dto.PageDTO;
import cybersoft.javabackend.moviejava14.phịm.dto.CreatePhimDTO;
import cybersoft.javabackend.moviejava14.phịm.dto.PhimDTO;
import cybersoft.javabackend.moviejava14.phịm.dto.ThongTinPhimDTO;
import cybersoft.javabackend.moviejava14.phịm.dto.UpdatePhimDTO;

public interface PhimService {
	
	List<PhimDTO> searchPhim(String tuKhoa, Pageable pageable);
	
	PageDTO<PhimDTO> searchPhimPaging(String tuKhoa, Pageable pageable);

	PageDTO<PhimDTO> searchPhimByNgayKhoiChieuPaging(String tuNgay, String denNgay, Pageable pageable);

	PhimDTO create(CreatePhimDTO dto, String fileName);
	
	PhimDTO update(UpdatePhimDTO dto, String fileName);

	void delete(int maPhim);

	ThongTinPhimDTO getPhimByMaPhim(int maPhim);
}
