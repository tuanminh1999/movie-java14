package cybersoft.javabackend.moviejava14.ghe.repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;

@Repository
public interface GheRepository extends JpaRepository<Ghe, UUID> {
	
	Optional<Ghe> findByTenGhe(String tenGhe);
}
