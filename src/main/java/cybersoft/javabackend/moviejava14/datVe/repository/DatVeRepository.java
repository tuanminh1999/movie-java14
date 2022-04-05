package cybersoft.javabackend.moviejava14.datVe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.datVe.entity.DatVe;

@Repository
public interface DatVeRepository extends JpaRepository<DatVe, Integer>{
	
}
