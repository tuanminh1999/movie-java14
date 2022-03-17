package cybersoft.javabackend.moviejava14.ghe.entity;

import java.util.UUID;

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
@Table(name="ghe")

public class Ghe extends BaseEntity {
	
//	so_thu_tu integer,
//	kich_hoat integer,
//	rap_id integer,
//	loai_ghe_id uuid,
		
		private static final long serialVersionUID = 1L;
		
		
	
		
		
		
		@Column(name="so_thu_tu")
		private int soThuTu;
		@Column(name="kich_hoat")
		private int kichHoat;
		@Column(name = "rap_id")
		private int rapId;
		
//		@Column(name = "loai_ghe_id")
//		private UUID loaiGheId;
		@ManyToOne
		@JoinColumn(name = "loai_ghe_id")
		private LoaiGhe loaiGhe;
		
		


}		

