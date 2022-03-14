package cybersoft.javabackend.moviejava14.heThongRap.entity;

import java.io.Serializable;
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
@Table(name = "he_thong_rap")
public class HeThongRap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2503631661050612697L;
	
	@Id
	@Column(name = "id")
	private String maHeThongRap;
	
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
	
	@Column(name="ten_he_thong_rap")
	private String tenHeThongRap;
	
	@Column(name="bi_danh")
	private String biDanh;
	
	@Column(name="logo")
	private String logo;
	
	@OneToMany(mappedBy = "cumRap", cascade = { CascadeType.PERSIST, CascadeType.MERGE }) 
	private Set<NguoiDung> cumRaps;
	
}
