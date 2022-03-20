package cybersoft.javabackend.moviejava14.rap.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rap")
public class Rap{
	
	@Id
	@Column (name = "id")
	private String maRap;
	
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
	
	@Column(name = "ten_rap")
	private String tenRap;
	
	@ManyToOne
	@JoinColumn(name = "cum_rap_id")
	private CumRap cumRap;
}
