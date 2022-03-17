package cybersoft.javabackend.moviejava14.ghe.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;

public interface GheRepository extends JpaRepository<LoaiGhe, UUID> {
	
	Optional<Ghe> findByTenGhe(String tenGhe);
}
