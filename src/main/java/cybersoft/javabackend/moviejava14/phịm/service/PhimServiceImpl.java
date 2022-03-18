package cybersoft.javabackend.moviejava14.phịm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.phịm.dto.PhimDTO;
import cybersoft.javabackend.moviejava14.phịm.dto.PhimMapper;
import cybersoft.javabackend.moviejava14.phịm.entity.Phim;
import cybersoft.javabackend.moviejava14.phịm.repository.PhimRepository;

@Service
public class PhimServiceImpl implements PhimService{
	
	private PhimRepository phimRepository;
	
	public PhimServiceImpl(PhimRepository phimRepository) {
		this.phimRepository = phimRepository;
	}

	@Override
	public List<PhimDTO> searchPhim(String tuKhoa, Pageable pageable) {
		List<Phim> phims = null;
		if(tuKhoa != null && pageable == null) {
			phims = phimRepository.findByTenPhimContainingOrBiDanhContaining(tuKhoa, tuKhoa, null);
		} else if (tuKhoa == null && pageable != null) {
			phims = phimRepository.findAllPaging(pageable);
		} else if (tuKhoa != null && pageable != null) {
			phims = phimRepository.findByTenPhimContainingOrBiDanhContaining(tuKhoa, tuKhoa, pageable);
		} else {
			phims = phimRepository.findAll();
		}
		return phims.stream().map(p -> PhimMapper.INSTANCE.fromEntityToPhimDTO(p)).collect(Collectors.toList());
	}

}
