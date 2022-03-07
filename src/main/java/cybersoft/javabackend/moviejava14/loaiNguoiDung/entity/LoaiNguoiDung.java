package cybersoft.javabackend.moviejava14.loaiNguoiDung.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loai_nguoi_dung")
public class LoaiNguoiDung {
	
	@Id
	@Column(name = "id")
	private String maLoaiNguoiDung;
	
	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

	@LastModifiedBy
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "ten_loai_nguoi_dung", unique = true)
	private String tenLoai;

	@OneToMany(mappedBy = "loaiNguoiDung", cascade = { CascadeType.PERSIST, CascadeType.MERGE }) 
	private Set<NguoiDung> nguoiDungs;
}
