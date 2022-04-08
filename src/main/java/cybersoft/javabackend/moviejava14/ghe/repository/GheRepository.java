package cybersoft.javabackend.moviejava14.ghe.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;

@Repository
public interface GheRepository extends JpaRepository<Ghe, Integer> {
	
	Optional<Ghe> findByTenGhe(String tenGhe);

	//@Query("FROM Ghe g INNER JOIN g.rap r WHERE g.tenGhe = ?1 AND r.maRap = ?2")
	Optional<Ghe> findByTenGheAndRap(String tenGhe, Rap maRap);
	
	//@Query("FROM Ghe g INNER JOIN g.rap r WHERE g.stt = ?1 AND r.maRap = ?2")
	Optional<Ghe> findBySttAndRap(int stt, Rap maRap);

	Optional<List<Ghe>> findByRapOrderByMaGheAsc(Rap rap);

}
