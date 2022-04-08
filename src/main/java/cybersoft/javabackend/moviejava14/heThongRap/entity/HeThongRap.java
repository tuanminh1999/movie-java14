package cybersoft.javabackend.moviejava14.heThongRap.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "he_thong_rap")
public class HeThongRap extends BaseEntity {

	private static final long serialVersionUID = 2503631661050612697L;

	@Id
	@Column(name = "id")
	private String maHeThongRap;

	@Column(name = "ten_he_thong_rap", unique = true)
	@NotNull
	private String tenHeThongRap;

	@Column(name = "bi_danh", unique = true)
	@NotNull
	private String biDanh;

	@Column(name = "logo")
	private String logo;

	@OneToMany(mappedBy = "heThongRap", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private Set<CumRap> danhSachCumRap;

}
