package cybersoft.javabackend.moviejava14.cumRap.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;

@Repository
public interface CumRapRepository extends JpaRepository<CumRap, String> {

	boolean findByTenCumRap(String tenCumRap);

	Optional<List<CumRap>> findByHeThongRap(HeThongRap heThongRap);

}
