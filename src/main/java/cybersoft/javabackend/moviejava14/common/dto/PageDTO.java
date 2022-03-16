package cybersoft.javabackend.moviejava14.common.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDTO<T> {
	
	private int currentPage;
	
	private int count;
	
	private int totalPages;
	
	private int totalCount;
	
	private List<T> items;
}
