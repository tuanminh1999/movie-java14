package cybersoft.javabackend.moviejava14.lichchieu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import cybersoft.javabackend.moviejava14.phịm.entity.Phim;

@Repository
public interface LichChieuRepository extends JpaRepository<LichChieu, Integer>{

	Optional<List<LichChieu>> findByPhim(Phim phim);

	
}
