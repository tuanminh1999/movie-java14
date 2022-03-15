package cybersoft.javabackend.moviejava14.nguoiDung.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.moviejava14.nguoiDung.dto.NguoiDungProjection;
import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, UUID>{

	Optional<NguoiDung> findByTaiKhoan(String username);

	Optional<NguoiDung> findByEmail(String email);

	Optional<NguoiDung> findBySoDt(String soDt);

	@Query("SELECT nd.taiKhoan as taiKhoan, nd.hoTen as hoTen, nd.email as email, nd.soDt as soDt, l.maLoaiNguoiDung as maLoaiNguoiDung"
			+ " FROM NguoiDung nd LEFT JOIN nd.loaiNguoiDung l")
	List<NguoiDungProjection> findAllDTO();
	
	@Query("SELECT nd.taiKhoan as taiKhoan, nd.hoTen as hoTen, nd.email as email, nd.soDt as soDt, l.maLoaiNguoiDung as maLoaiNguoiDung"
			+ " FROM NguoiDung nd LEFT JOIN nd.loaiNguoiDung l WHERE nd.taiKhoan LIKE %:tuKhoa% OR nd.hoTen LIKE %:tuKhoa%")
	List<NguoiDungProjection> searchByTaiKhoanOrHoTen(String tuKhoa);
	
}
