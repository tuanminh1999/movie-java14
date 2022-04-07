package cybersoft.javabackend.moviejava14.loaiNguoiDung.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loai_nguoi_dung")
public class LoaiNguoiDung extends BaseEntity{
	
	private static final long serialVersionUID = 4766770617680553069L;

	@Id
	@Column(name = "id")
	private String maLoaiNguoiDung;
	
	@Column(name = "ten_loai_nguoi_dung", unique = true)
	@NotNull
	private String tenLoai;

	@OneToMany(mappedBy = "loaiNguoiDung")
	private Set<NguoiDung> danhSachNguoiDung = new HashSet<NguoiDung>();
}
