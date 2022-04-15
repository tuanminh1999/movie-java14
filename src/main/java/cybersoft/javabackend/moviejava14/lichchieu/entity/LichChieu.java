package cybersoft.javabackend.moviejava14.lichchieu.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.datVe.entity.DatVe;
import cybersoft.javabackend.moviejava14.phịm.entity.Phim;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lich_chieu")
public class LichChieu extends BaseEntity{
	
	private static final long serialVersionUID = 937278456525378407L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maLichChieu;
	
	@ManyToOne
	@JoinColumn(name = "rap_id", nullable = false)
	private Rap rap;
	
	@ManyToOne
	@JoinColumn(name = "phim_id", nullable = false)
	private Phim phim;
	
	@Column(name = "ngay_chieu_gio_chieu", nullable = false)
	private Timestamp ngayGioChieu;
	
	@Column(name = "gia_ve", nullable = false)
	private int giaVe;
	
	@Column(name = "thoi_luong", nullable = false)
	private int thoiLuong;
	
	@OneToMany(mappedBy = "maLichChieu")
	private List<DatVe> dateVes;
	
}
