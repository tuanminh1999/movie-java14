package cybersoft.javabackend.moviejava14.phim.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phim")
public class Phim extends BaseEntity{

	private static final long serialVersionUID = -7946428433396162928L;

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
	
}
