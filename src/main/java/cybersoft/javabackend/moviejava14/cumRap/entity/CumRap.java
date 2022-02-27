package cybersoft.javabackend.moviejava14.cumRap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cybersoft.javabackend.moviejava14.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cum_rap")
public class CumRap extends BaseEntity {
	
	@Column(name="ten_cum_rap")
	private String tenCumRap;
}
