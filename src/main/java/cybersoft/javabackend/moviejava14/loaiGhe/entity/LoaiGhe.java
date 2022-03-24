package cybersoft.javabackend.moviejava14.loaiGhe.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import cybersoft.javabackend.moviejava14.ghe.entity.Ghe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="loai_ghe")
public class LoaiGhe {
	
	@Id
	@Column(name = "id")
	private String maLoaiGhe;

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
	
	@Column(name="mo_ta")
	private String moTa;
	
	@Column(name="ten_loai_ghe")
	private String tenLoaiGhe;
	
	@OneToMany(mappedBy = "loaiGheEntity")
	private List<Ghe> ghes;

}
