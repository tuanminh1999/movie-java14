package cybersoft.javabackend.moviejava14.rap.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.rap.entity.Rap;

@Repository
public interface RapRepository extends JpaRepository<Rap, String>{

	boolean findByTenRap(String tenRap);

}
