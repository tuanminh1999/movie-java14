package cybersoft.javabackend.moviejava14.rap.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;

@Repository
public interface RapRepository extends JpaRepository<Rap, String>{

	boolean findByTenRap(String tenRap);

	Optional<List<Rap>> findByCumRap(CumRap byId);
	
}
