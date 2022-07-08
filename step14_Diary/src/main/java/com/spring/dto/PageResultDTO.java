package com.spring.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class PageResultDTO<DTO, EN> {

	// DTO 리스트
	private List<DTO> dtoList;
	// 전체 페이지 번호
	private int totalPage;

	// 현재 페이지 번호
	private int page;

	// 목록(출력되는 DTO) 사이즈
	private int size;

	// 시작 페이지 번호, 마지막 페이지 번호
	private int start, end;
	// 이전버튼, 다음버튼
	private boolean prev, next;

	// 목록(페이지 번호) 대한 목록
	private List<Integer> pageList;

	//
	public PageResultDTO(Page<EN> result,Function<EN, DTO> function) {
		dtoList = result.stream().map(function).collect(Collectors.toList());
		
		totalPage = result.getTotalPages();
		
		buildPageList(result.getPageable());
	}

	// pageList 생성
	private void buildPageList(Pageable pageable) {
		this.page = pageable.getPageNumber() + 1;  
		this.size = pageable.getPageSize();

		// 끝번호를 구할 때 (페이지 번호가 10개)
		int endPage = (int) (Math.ceil(page / 10.0)) * 10;

		start = endPage - 9;

		prev = start > 1;

		end = totalPage > endPage ? endPage : totalPage;

		next = totalPage > endPage;

		pageList = IntStream.rangeClosed(start, end).boxed()
				.collect(Collectors.toList());	
	}
}
