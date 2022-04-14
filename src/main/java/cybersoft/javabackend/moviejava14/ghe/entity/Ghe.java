package cybersoft.javabackend.moviejava14.ghe.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.moviejava14.entities.BaseEntity;
import cybersoft.javabackend.moviejava14.datVe.entity.DatVe;
import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ghe")
public class Ghe extends BaseEntity {

	private static final long serialVersionUID = 305822121698752454L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int maGhe;

	@Column(name = "ten_ghe")
	@NotNull
	private String tenGhe;

	@Column(name = "so_thu_tu")
	private int stt;

	@Column(name = "kich_hoat")
	private boolean daDat;

	@ManyToOne
	@JoinColumn(name = "rap_id")
	@NotNull
	private Rap rap;

	@ManyToOne
	@JoinColumn(name = "loai_ghe_id")
	@NotNull
	private LoaiGhe loaiGheEntity;

	@OneToMany(mappedBy = "maGhe", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<DatVe> danhSachDatVe;

}
