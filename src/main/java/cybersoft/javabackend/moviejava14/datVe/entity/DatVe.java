package cybersoft.javabackend.moviejava14.datVe.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dat_ve")
@Getter
@Setter
public class DatVe extends BaseEntity{
	
	private static final long serialVersionUID = -6320513837601982136L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ngay_dat")
	private Timestamp ngayDat;
	
	@ManyToOne
	@JoinColumn(name = "lich_chieu_id")
	private LichChieu maLichChieu;
	
	@Column(name = "gia_ve")
	private int giaVe;
	
	@ManyToOne
	@JoinColumn(name = "ghe_id")
	private Ghe maGhe;
	
	@ManyToOne
	@JoinColumn(name = "nguoi_dung_id")
	private NguoiDung taiKhoanNguoiDung;
}
