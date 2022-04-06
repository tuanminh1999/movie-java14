package cybersoft.javabackend.moviejava14.datVe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.datVe.entity.DatVe;
import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;

@Repository
public interface DatVeRepository extends JpaRepository<DatVe, Integer>{

	Optional<List<DatVe>> findByMaGhe(Ghe ghe);
	
}
