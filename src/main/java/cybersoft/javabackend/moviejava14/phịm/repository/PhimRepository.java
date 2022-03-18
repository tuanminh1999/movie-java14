package cybersoft.javabackend.moviejava14.phịm.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.phịm.entity.Phim;

@Repository
public interface PhimRepository extends JpaRepository<Phim, UUID>{
	
	@Query("FROM Phim p")
	List<Phim> findAllPaging(Pageable pageable);
		
	List<Phim> findByTenPhimContainingOrBiDanhContaining(String tenPhim, String biDanh, Pageable pageable);

}
