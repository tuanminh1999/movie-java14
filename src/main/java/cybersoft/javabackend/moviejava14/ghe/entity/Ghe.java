package cybersoft.javabackend.moviejava14.ghe.entity;

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
		private String maGhe;
		@Column(name="ten_ghe")
		private String tenGhe;
		@Column(name="ma_rap")
		private String maRap;
		@Column(name="loai_ghe")
		private String loaiGhe;
		@Column(name="ma_ghe")
		private String maGhe;
		@Column(name="ten_ghe")
		private String tenGhe;
		@Column(name="ma_rap")
		private String maRap;
		@Column(name="loai_ghe")
		private String loaiGhe;


}		
