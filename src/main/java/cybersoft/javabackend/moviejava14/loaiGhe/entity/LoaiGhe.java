package cybersoft.javabackend.moviejava14.loaiGhe.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="loai_ghe")
public class LoaiGhe extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="mo_ta")
	private String moTa;
	
	@Column(name="ten_loai_ghe")
	private String tenLoaiGhe;

}
