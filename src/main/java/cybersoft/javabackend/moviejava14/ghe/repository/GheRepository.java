package cybersoft.javabackend.moviejava14.ghe.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.ghe.dto.GheDTO;
import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;

@Repository
public interface GheRepository extends JpaRepository<Ghe, Integer> {
	
	Optional<Ghe> findByTenGhe(String tenGhe);

	@Query("FROM Ghe g INNER JOIN g.rap r WHERE g.tenGhe = ?1 AND r.maRap = ?2")
	Optional<GheDTO> findByTenGheAndMaRap(String tenGhe, String maRap);
	
	@Query("FROM Ghe g INNER JOIN g.rap r WHERE g.stt = ?1 AND r.maRap = ?2")
	Optional<Ghe> findBySttAndMaRap(int stt, String maRap);

}
