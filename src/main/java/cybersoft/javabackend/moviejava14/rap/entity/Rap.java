package cybersoft.javabackend.moviejava14.rap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import cybersoft.javabackend.moviejava14.cumRap.entity.CumRap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rap")
public class Rap extends BaseEntity{
	
	private static final long serialVersionUID = 1247875516538579374L;
	
	@Column(name = "ten_rap")
	private String tenRap;
	
	@ManyToOne
	@JoinColumn(name = "cum_rap_id")
	private CumRap cumRap;
}
