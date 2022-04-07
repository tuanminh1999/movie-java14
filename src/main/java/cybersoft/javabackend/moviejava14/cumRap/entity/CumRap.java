package cybersoft.javabackend.moviejava14.cumRap.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cum_rap")
public class CumRap extends BaseEntity {
	
	private static final long serialVersionUID = 5194453491499231201L;
	
	@Id
	@Column (name = "id")
	private String maCumRap;
	
	@Column(name="ten_cum_rap", unique = true)
	@NotNull
	private String tenCumRap;
	
	@Column(name="dia_chi", unique = true)
	@NotNull
	private String diaChi;
	
	@ManyToOne
	@JoinColumn(name = "he_thong_rap_id")
	@NotNull
	private HeThongRap heThongRap;
	
	@OneToMany(mappedBy = "cumRap")
	private Set<Rap> danhSachRap = new HashSet<Rap>();
}
