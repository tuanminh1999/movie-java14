package cybersoft.javabackend.moviejava14.loaiGhe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "loai_ghe")
public class LoaiGhe extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ten_loai_ghe")
	private String tenLoaiGhe;
	
	@Column(name = "mo_ta")
	private int moTa;

}
