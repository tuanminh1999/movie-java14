package cybersoft.javabackend.moviejava14.ghe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ghe")
public class Ghe extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ten_ghe")
	private String tenGhe;
	
	@Column(name = "so_thu_tu")
	private int stt;
	
	@Column(name = "kich_hoat")
	private boolean daDat;
		
	@Column(name = "gia_ve")
	private int giaVe;
	
//	@ManyToOne
//	@JoinColumn(name = "rap_id")
//	private Rap rap;
	
	@ManyToOne
	@JoinColumn(name = "loai_ghe_id")
	private LoaiGhe loaiGhe;

}
