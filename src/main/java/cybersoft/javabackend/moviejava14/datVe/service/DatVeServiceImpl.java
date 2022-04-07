package cybersoft.javabackend.moviejava14.datVe.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.common.utils.DateFormatter;
import cybersoft.javabackend.moviejava14.datVe.dto.CreateDatVeDTO;
import cybersoft.javabackend.moviejava14.datVe.dto.DanhSachGheDTO;
import cybersoft.javabackend.moviejava14.datVe.dto.DanhSachVeDTO;
import cybersoft.javabackend.moviejava14.datVe.dto.DatVeDTO;
import cybersoft.javabackend.moviejava14.datVe.dto.ThongTinPhimDTO;
import cybersoft.javabackend.moviejava14.datVe.entity.DatVe;
import cybersoft.javabackend.moviejava14.datVe.repository.DatVeRepository;
import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import cybersoft.javabackend.moviejava14.ghe.repository.GheRepository;
import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import cybersoft.javabackend.moviejava14.lichchieu.repository.LichChieuRepository;
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
	public boolean create(CreateDatVeDTO dto) {
		DatVe datVe = null;
		for(DanhSachVeDTO o : dto.getDanhSachVe()) {
			datVe = new DatVe();
			datVe.setNgayDat(new Timestamp(System.currentTimeMillis()));
			datVe.setMaLichChieu(lichChieuRepository.findById(dto.getMaLichChieu()).get());
			datVe.setTaiKhoanNguoiDung(nguoiDungRepository.findByTaiKhoan(dto.getTaiKhoanNguoiDung()).get());
			datVe.setMaGhe(gheRepository.findById(o.getMaGhe()).get());
			datVe.setGiaVe(o.getGiaVe());
			datVeRepository.save(datVe);
		}
		return true;
	}

	@Override
	public Object getDatVe(int maLichChieu) {
		LichChieu lc = lichChieuRepository.findById(maLichChieu).get();
		ThongTinPhimDTO thongTinPhimDTO = new ThongTinPhimDTO();
		thongTinPhimDTO.setMaLichChieu(lc.getMaLichChieu());
		thongTinPhimDTO.setTenCumRap(lc.getRapLichChieu().getCumRap().getTenCumRap());
		thongTinPhimDTO.setTenRap(lc.getRapLichChieu().getTenRap());
		thongTinPhimDTO.setTenPhim(lc.getPhim().getTenPhim());
		thongTinPhimDTO.setHinhAnh(lc.getPhim().getHinhAnh());
		thongTinPhimDTO.setDiaChi(lc.getRapLichChieu().getCumRap().getDiaChi());
		thongTinPhimDTO.setNgayChieu(DateFormatter.convertIntoVietNameseDate(DateFormatter.getDate(lc.getNgayChieuGioChieu())));
		thongTinPhimDTO.setGioChieu(DateFormatter.getTime(lc.getNgayChieuGioChieu()));
		
		List<DanhSachGheDTO> danhSachGheDTOList = new LinkedList<DanhSachGheDTO>();
		
		for(Ghe o : gheRepository.findByRapOrderByMaGheAsc(lc.getRapLichChieu()).get()) {
			DanhSachGheDTO danhSachGheDTO = new DanhSachGheDTO();
			danhSachGheDTO.setMaRap(o.getRap().getMaRap());
			danhSachGheDTO.setMaGhe(o.getMaGhe());
			danhSachGheDTO.setTenGhe(o.getTenGhe());
			danhSachGheDTO.setLoaiGhe(o.getLoaiGheEntity().getMaLoaiGhe());
			danhSachGheDTO.setStt(o.getStt());
			if(o.getLoaiGheEntity().getMaLoaiGhe().equals("Vip")) {
				danhSachGheDTO.setGiaVe(lc.getGiaVe() * 2);
			} else {
				danhSachGheDTO.setGiaVe(lc.getGiaVe());
			}
			
			for(DatVe o1 : datVeRepository.findByMaGhe(o).get()){
				if(o.equals(o1.getMaGhe()) && lc.getMaLichChieu() == o1.getMaLichChieu().getMaLichChieu()) {
					danhSachGheDTO.setDaDat(true);
					danhSachGheDTO.setTaiKhoanNguoiDat(o1.getTaiKhoanNguoiDung().getTaiKhoan());
				} else {
					danhSachGheDTO.setDaDat(false);
					danhSachGheDTO.setTaiKhoanNguoiDat(null);
				}
			}
			danhSachGheDTOList.add(danhSachGheDTO);
		}
		

		DatVeDTO dv = new DatVeDTO();
		dv.setThongTinPhim(thongTinPhimDTO);
		dv.setDanhSachGhe(danhSachGheDTOList);
		return dv;
	}

}
