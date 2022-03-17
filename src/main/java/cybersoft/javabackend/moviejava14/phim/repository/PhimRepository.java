package cybersoft.javabackend.moviejava14.phim.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.phim.entity.Phim;

@Repository
public interface PhimRepository extends JpaRepository<Phim, UUID>{

}
