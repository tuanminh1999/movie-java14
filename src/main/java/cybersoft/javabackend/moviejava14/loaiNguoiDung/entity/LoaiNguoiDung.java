package cybersoft.javabackend.moviejava14.loaiNguoiDung.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loai_nguoi_dung")
public class LoaiNguoiDung extends BaseEntity {

	private static final long serialVersionUID = 5357730766250352828L;

	@Column(name = "ten_loai_nguoi_dung")
	private String tenLoaiNguoiDung;

}
