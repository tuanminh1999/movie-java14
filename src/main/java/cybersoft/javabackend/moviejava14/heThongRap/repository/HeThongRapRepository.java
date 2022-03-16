package cybersoft.javabackend.moviejava14.heThongRap.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;

public interface HeThongRapRepository extends JpaRepository<HeThongRap, String> {

	Optional<HeThongRap> findByTenHeThongRap(String tenHeThongRap);

}
