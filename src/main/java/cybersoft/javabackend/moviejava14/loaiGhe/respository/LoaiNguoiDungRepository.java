package cybersoft.javabackend.moviejava14.loaiGhe.respository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;

@Repository
public interface LoaiNguoiDungRepository {
	Optional<LoaiNguoiDung> findByTenLoaiNguoiDung(String tenLoaiNguoiDung);
}
