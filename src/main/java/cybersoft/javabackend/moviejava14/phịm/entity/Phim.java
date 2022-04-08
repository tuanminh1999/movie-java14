package cybersoft.javabackend.moviejava14.phịm.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phim")
public class Phim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maPhim;

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
	
	@OneToMany(mappedBy = "phim", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }) 
	private Set<LichChieu> lichChieuPhims;
}
