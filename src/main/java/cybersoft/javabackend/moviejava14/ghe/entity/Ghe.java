package cybersoft.javabackend.moviejava14.ghe.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ghe")

public class Ghe extends BaseEntity {
	
	
		
		private static final long serialVersionUID = 1L;
		
		@Column(name="ma_ghe")
		private int maGhe;
		@Column(name="ten_ghe")
		private String tenGhe;
		@Column(name="ma_rap")
		private int maRap;
		@Column(name="loai_ghe")
		private String loaiGhe;
		@Column(name="gia_ve")
		private int giaVe;
		@Column(name="da_dat")
		private boolean daDat;
		@Column(name="so_thu_tu")
		private int soThuTU;
		@Column(name="kich_hoat")
		private int kichHoat;
		@Column(name = "rap_id")
		private int rapId;
		@Column(name = "loai_ghe_id")
		private UUID loaiGheId;


}		
