package cybersoft.javabackend.moviejava14.lichchieu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;

@Repository
public interface LichChieuRepository extends JpaRepository<LichChieu, Integer>{

}
