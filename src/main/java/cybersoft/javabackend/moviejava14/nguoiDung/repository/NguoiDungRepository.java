package cybersoft.javabackend.moviejava14.nguoiDung.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, UUID>{

	Optional<NguoiDung> findByTaiKhoan(String username);
	
}
