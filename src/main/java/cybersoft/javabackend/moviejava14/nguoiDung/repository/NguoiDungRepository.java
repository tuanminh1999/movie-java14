package cybersoft.javabackend.moviejava14.nguoiDung.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer>{

	Optional<NguoiDung> findByTaiKhoan(String username);

	Optional<NguoiDung> findByEmail(String email);

	Optional<NguoiDung> findBySoDt(String soDt);
	
	@Query("FROM NguoiDung nd")
	List<NguoiDung> findAllPaging(Pageable pageable);
	
	//@Query("FROM NguoiDung nd WHERE nd.taiKhoan LIKE %:tuKhoa% OR nd.hoTen LIKE %:tuKhoa%")
	List<NguoiDung> findByTaiKhoanContainingOrHoTenContaining(String taiKhoan, String hoTen);
	
	//@Query("FROM NguoiDung nd WHERE nd.taiKhoan LIKE %:tuKhoa% OR nd.hoTen LIKE %:tuKhoa%")
	List<NguoiDung> findByTaiKhoanContainingOrHoTenContaining(String taiKhoan, String hoTen, Pageable pageable);
	
}
