package cybersoft.javabackend.moviejava14.phịm.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import cybersoft.javabackend.moviejava14.phịm.dto.PhimDTO;

public interface PhimService {
	List<PhimDTO> searchPhim(String tuKhoa, Pageable pageable);
}
