package com.board.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class PageResultDTO<DTO,EN> {
	
	private List<DTO> dtoList;
	private int totalPage;
	private int page;
	private int size;
	private int start,end;
	private boolean prev,next;
	private List<Integer> pageList;
	
	
	public PageResultDTO(Page<EN> result, Function<EN, DTO> function) {
		dtoList = result.stream().map(function).collect(Collectors.toList());
		totalPage = result.getTotalPages();
		buildPageList(result.getPageable());
		
	}
	
	private void buildPageList(Pageable pageable) {
		this.page = pageable.getPageNumber() +1;
		this.size = pageable.getPageSize();
		
		int endPage = (int) (Math.ceil(page / 10.0)) * 10;
		
		start = endPage -9;
		prev = start>1;
		end = totalPage > endPage ? endPage: totalPage;
		next = totalPage > endPage;
		
		pageList = IntStream.rangeClosed(start, end).boxed()
				.collect(Collectors.toList());	
	}	
	

}
