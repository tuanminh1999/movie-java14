package cybersoft.javabackend.moviejava14.nguoiDung.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
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

	@Column(name = "tai_khoan")
	private String taiKhoan;

	@Column(name = "ho_ten")
	private String hoTen;

	@Column(name = "mat_khau")
	private String matKhau;

	@Column(name = "email")
	private  String email;

	@Column(name = "so_dien_thoai")
	private String soDt;
	
	@Column(name = "loai_nguoi_dung_id")
	private String maLoaiNguoiDung;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "nguoi_dung_loai_nguoi_dung",
		joinColumns = @JoinColumn(name = "nguoi_dung_id"),
		inverseJoinColumns = @JoinColumn(name = "loai_nguoi_dung_id"))
	private Set<LoaiNguoiDung> loaiNguoiDung = new LinkedHashSet<LoaiNguoiDung>();
}
