package cybersoft.javabackend.moviejava14.cumRap.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import cybersoft.javabackend.moviejava14.heThongRap.entity.HeThongRap;
import cybersoft.javabackend.moviejava14.rap.entity.Rap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cum_rap")
public class CumRap implements Serializable {
	
	private static final long serialVersionUID = 5194453491499231201L;
	
	@Id
	@Column (name = "id")
	private String maCumRap;
	
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
	
	@Column(name="ten_cum_rap")
	private String tenCumRap;
	
	@Column(name="dia_chi")
	private String diaChi;
	
	@ManyToOne
	@JoinColumn(name = "he_thong_rap_id")
	private HeThongRap heThongRap;
	
	@OneToMany(mappedBy = "cumRap")
	private Set<Rap> danhSachRap = new HashSet<Rap>();
}
