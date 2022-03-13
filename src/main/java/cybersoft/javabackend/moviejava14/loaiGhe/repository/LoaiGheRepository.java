package cybersoft.javabackend.moviejava14.loaiGhe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;

@Repository
public interface LoaiGheRepository extends JpaRepository<LoaiGhe, UUID> {
	
	Optional<LoaiGhe> findByTenLoaiGhe(String tenLoaiGhe);


}
