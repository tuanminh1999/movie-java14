package cybersoft.javabackend.moviejava14.ghe.entity;


import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import cybersoft.javabackend.moviejava14.loaiGhe.entity.LoaiGhe;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ghe")
public class Ghe {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private UUID maGhe;

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
	
	@Column(name = "ten_ghe")
	private String tenGhe;
	
	@Column(name = "so_thu_tu")
	private int stt;
	
	@Column(name = "kich_hoat")
	private boolean daDat;
	
	@ManyToOne
	@JoinColumn(name = "rap_id")
	private Rap rap;
	
	@ManyToOne
	@JoinColumn(name = "loai_ghe_id")
	private LoaiGhe loaiGheEntity;

}
