package cybersoft.javabackend.moviejava14.loaiNguoiDung.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loai_nguoi_dung")
public class LoaiNguoiDung extends BaseEntity {

	private static final long serialVersionUID = 5357730766250352828L;
	
	@Column(name = "ten_loai_nguoi_dung", unique = true)
	private String tenLoaiNguoiDung;

	@OneToMany(mappedBy = "loaiNguoiDung", cascade = { CascadeType.PERSIST, CascadeType.MERGE }) 
	private Set<NguoiDung> nguoiDungs;
}
