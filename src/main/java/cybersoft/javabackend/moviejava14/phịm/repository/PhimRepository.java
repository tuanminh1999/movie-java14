package cybersoft.javabackend.moviejava14.phịm.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.phịm.entity.Phim;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Integer> {

	@Query("FROM Phim p")
	List<Phim> findAllPaging(Pageable pageable);

	List<Phim> findByTenPhimContainingOrBiDanhContaining(String tenPhim, String biDanh, Pageable pageable);

	List<Phim> findByNgayKhoiChieuBetween(Timestamp tuNgay, Timestamp denNgay, Pageable pageable);
	
	List<Phim> findByNgayKhoiChieuAfter(Timestamp tuNgay, Pageable pageable);
	
	List<Phim> findByNgayKhoiChieuBefore(Timestamp denNgay, Pageable pageable);

	Optional<Phim> findByTenPhim(String tenPhim);

	Optional<Phim> findByBiDanh(String biDanh);

}
