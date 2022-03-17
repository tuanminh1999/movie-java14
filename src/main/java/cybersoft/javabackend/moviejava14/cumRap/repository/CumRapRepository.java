package cybersoft.javabackend.moviejava14.cumRap.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;

@Repository
public interface CumRapRepository extends JpaRepository<CumRap, String> {

	boolean findByTenCumRap(String tenCumRap);

}
