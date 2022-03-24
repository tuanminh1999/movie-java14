package cybersoft.javabackend.moviejava14.loaiGhe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;

@Repository
public interface LoaiGheRepository extends JpaRepository<LoaiGhe, String> {
	
	Optional<LoaiGhe> findByTenLoaiGhe(String tenLoaiGhe);


}
