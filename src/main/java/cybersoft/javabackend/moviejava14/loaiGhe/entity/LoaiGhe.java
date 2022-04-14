package cybersoft.javabackend.moviejava14.loaiGhe.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.moviejava14.entities.BaseEntity;
import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="loai_ghe")
public class LoaiGhe extends BaseEntity{
	
	private static final long serialVersionUID = -5435457049728576071L;

	@Id
	@Column(name = "id")
	private String maLoaiGhe;
	
	@Column(name="mo_ta")
	private String moTa;
	
	@Column(name="ten_loai_ghe", unique = true)
	@NotNull
	private String tenLoaiGhe;
	
	@OneToMany(mappedBy = "loaiGheEntity", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<Ghe> danhSachGhe;

}
