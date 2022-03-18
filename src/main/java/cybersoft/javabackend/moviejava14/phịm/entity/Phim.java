package cybersoft.javabackend.moviejava14.phịm.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phim")
public class Phim {
	
	@Id
	@GeneratedValue // tự động sinh id
	@Column(name = "id")
	private UUID maPhim;

	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

	@LastModifiedBy
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "ten_phim")
	private String tenPhim;
	
	@Column(name = "bi_danh")
	private String biDanh;
	
	private String trailer;
	
	@Column(name = "hinh_anh")
	private String hinhAnh;
	
	@Column(name = "mo_ta")
	private String moTa;
	
	@Column(name = "ngay_khoi_chieu")
	private Timestamp ngayKhoiChieu;
	
	@Column(name = "danh_gia")
	private int danhGia;
}
