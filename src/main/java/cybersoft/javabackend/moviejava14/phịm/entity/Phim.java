package cybersoft.javabackend.moviejava14.phịm.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phim")
public class Phim extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maPhim;
	
	@Column(name = "ten_phim", unique = true, nullable = false)
	private String tenPhim;
	
	@Column(name = "bi_danh", unique = true, nullable = false)
	private String biDanh;
	
	private String trailer;
	
	@Column(name = "hinh_anh")
	private String hinhAnh;
	
	@Column(name = "mo_ta")
	private String moTa;
	
	@Column(name = "ngay_khoi_chieu", nullable = false)
	private Timestamp ngayKhoiChieu;
	
	@Column(name = "danh_gia")
	private int danhGia;
	
	@OneToMany(mappedBy = "phim", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }) 
	private Set<LichChieu> lichChieuPhims;
}
