package cybersoft.javabackend.moviejava14.loaiNguoiDung.repositoty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;

@Repository
public interface LoaiNguoiDungRepository extends JpaRepository<LoaiNguoiDung, String> {
	Optional<LoaiNguoiDung> findByTenLoaiNguoiDung(String tenLoaiNguoiDung);
}
