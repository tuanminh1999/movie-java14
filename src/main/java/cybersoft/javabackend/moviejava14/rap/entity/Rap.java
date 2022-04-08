package cybersoft.javabackend.moviejava14.rap.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import cybersoft.javabackend.moviejava14.lichchieu.entity.LichChieu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rap")
public class Rap extends BaseEntity{
	
	private static final long serialVersionUID = -3185533762721286682L;

	@Id
	@Column (name = "id")
	private String maRap;
	
	@Column(name = "ten_rap")
	private String tenRap;
	
	@ManyToOne
	@JoinColumn(name = "cum_rap_id")
	private CumRap cumRap;
	
	@OneToMany(mappedBy = "rap")
	private Set<Ghe> danhSachGhe;
	
	@OneToMany(mappedBy = "rapLichChieu", cascade = { CascadeType.PERSIST, CascadeType.MERGE }) 
	private Set<LichChieu> danhSachLichChieu;
}
