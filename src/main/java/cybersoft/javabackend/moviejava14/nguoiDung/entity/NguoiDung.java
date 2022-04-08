package cybersoft.javabackend.moviejava14.nguoiDung.entity;

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

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.datVe.entity.DatVe;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "nguoi_dung")
public class NguoiDung extends BaseEntity {

	private static final long serialVersionUID = 94647127648272572L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "tai_khoan", unique = true)
	@NotNull
	private String taiKhoan;

	@Column(name = "ho_ten")
	@NotNull
	private String hoTen;

	@Column(name = "mat_khau")
	@NotNull
	private String matKhau;

	@Column(name = "email", unique = true)
	@NotNull
	private String email;

	@Column(name = "so_dien_thoai", unique = true)
	@NotNull
	private String soDt;

	@ManyToOne
	@JoinColumn(name = "loai_nguoi_dung_id")
	@NotNull
	private LoaiNguoiDung loaiNguoiDung;

	@OneToMany(mappedBy = "taiKhoanNguoiDung", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private List<DatVe> dateVes;
}
