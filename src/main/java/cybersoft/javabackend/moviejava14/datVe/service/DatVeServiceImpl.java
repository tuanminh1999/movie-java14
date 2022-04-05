package cybersoft.javabackend.moviejava14.datVe.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import cybersoft.javabackend.moviejava14.datVe.dto.CreateDatVeDTO;
import cybersoft.javabackend.moviejava14.datVe.dto.DanhSachVeDTO;
import cybersoft.javabackend.moviejava14.datVe.entity.DatVe;
import cybersoft.javabackend.moviejava14.datVe.repository.DatVeRepository;
import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import cybersoft.javabackend.moviejava14.ghe.repository.GheRepository;
import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import cybersoft.javabackend.moviejava14.lichchieu.repository.LichChieuRepository;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungMapper;
import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.repository.NguoiDungRepository;

@Service
public class DatVeServiceImpl implements DatVeService{
	
	@Autowired
	private GheRepository gheRepository;
	
	@Autowired
	private LichChieuRepository lichChieuRepository;
	
	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	@Autowired
	private DatVeRepository datVeRepository;

	@Override
	public Object create(CreateDatVeDTO dto) {
		DatVe datVe = null;
		for(DanhSachVeDTO o : dto.getDanhSachVe()) {
			datVe = new DatVe();
			datVe.setNgayDat(new Timestamp(System.currentTimeMillis()));
			datVe.setMaLichChieu(lichChieuRepository.findById(dto.getMaLichChieu()).get());
			datVe.setTaiKhoanNguoiDung(nguoiDungRepository.findByTaiKhoan(dto.getTaiKhoanNguoiDung()).get());
			datVe.setMaGhe(gheRepository.findById(o.getMaGhe()).get());
			datVe.setGiaVe(o.getGiaVe());
		}
		
//		Optional<LoaiNguoiDung> loaiNguoiDung = loaiNguoiDungRepository.findById(dto.getMaLoaiNguoiDung());
//		if (!loaiNguoiDung.isPresent()) {
//			throw new InvalidDataException("Loại người dùng không tồn tại");
//		} else {
//			nguoiDung.setLoaiNguoiDung(loaiNguoiDung.get());
//		}
		DatVe createDatVe = datVeRepository.save(datVe);
		return createDatVe;
	}

}
