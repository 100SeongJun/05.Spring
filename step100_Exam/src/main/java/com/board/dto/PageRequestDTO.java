package com.board.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageRequestDTO {

	private int page;
	private int size;
	
	public PageRequestDTO() {
		this.page=1;
		this.size=10;
	}
	
	public Pageable getPageable(Sort sort) {
		return PageRequest.of(page-1,size,sort.descending());
	}
}
