package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepo;
import com.spring.service.DiaryServiceImpl;

@RestController
//@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드(멤버변수)의 생성자를  자동생성하는 어노테이션
@CrossOrigin(origins = { "http://localhost:3000" })
public class DiaryController {
	@Autowired
	DiaryServiceImpl diaryImpl;
//	private final DiaryServiceImpl diaryImpl; //13Line과 한 쌍

	@Autowired
	DiaryRepo diaryrepo;

	@PostMapping(value = "/diary")
	public Diary insertDiary(@RequestBody DiaryDTO diaryDTO) {
		return diaryImpl.insertDiary(diaryDTO);
	}

	@PostMapping(value = "/diary-batch")
	public Diary insertDiaryBatch() {
		List<DiaryDTO> diaryDTOList = new ArrayList<DiaryDTO>();
		IntStream.rangeClosed(1, 200).forEach(i -> {
			DiaryDTO diaryDTO = DiaryDTO.builder().no(Long.valueOf(i))
					.title("Title : " + i).content("Content : " + i).build();
			diaryDTOList.add(diaryDTO);
		});
		diaryImpl.insertDiaryBatch(diaryDTOList);
		return null;
	}

	// 페이지 처리
	// pageable 인터페이스 -> 구현체 PageRequest
	// 내부 static of 메소드를 사용
	// of(int page, int size) : 페이지 번호 (0부터시작), 개수
	// of(int page, int size,Sort sort): 페이지번호, 개수, 정렬

	@GetMapping("/pageable")
	public void pageDefault() {
		// 정렬
//		Sort sort = Sort.by("no").descending();
//		Pageable pageable1 = PageRequest.of(0, 10,sort);

//		// 미정렬
//		Pageable pageable1 = PageRequest.of(0, 10);
//		Page<Diary> result = diaryrepo.findAll(pageable1);
//		System.out.println(result);
//		System.out.println("====pageable result ====");
//		// 전체 페이지 수
//		System.out.println(result.getTotalPages());
//		// 전체 개수
//		System.out.println(result.getTotalElements());
//		// 현재 페이지 번호: 0부터 시작
//		System.out.println(result.getNumber());
//		// 페이지당 데이터 개수
//		System.out.println(result.getSize());
//		// 다음페이지 혹은 이전페이지
//		System.out.println(result.hasNext());
//		System.out.println(result.hasPrevious());
//		// 모든 데이터
////		System.out.println(result.getContent());
//		for (Diary diary : result.getContent()) {
//			System.out.println(diary);
//
//		}
//		System.out.println("=== 쿼리메소드 + Pageable===");
//		//쿼리메소드 + Pageable
//		Pageable pageable3 = PageRequest.of(0, 10,Sort.by("no").descending());
//		Page<Diary> result3 = diaryrepo.findByNoBetween(10L,50L,pageable3);
//		result3.get().forEach(diary-> System.out.println(diary));

		// 고려사항
		// Entity -> DTO
		// DTO -> Pageable
		// 페이지 번호에 대한 값 PageReqeust.of(page_number(가변),10(고정),정렬)
		//
		// 페이지를 받았을 경우에는 DTO를 사용하여 재사용을 해줘야함.
		System.out.println("===PageRequestDTO===");
		PageRequestDTO pRDTO = PageRequestDTO.builder().page(1).size(10)
				.build();
		PageResultDTO<DiaryDTO, Diary> pageResultDTO = diaryImpl.getList(pRDTO);
		System.out.println(pageResultDTO.isPrev()); // false
		System.out.println(pageResultDTO.isNext()); // next
		System.out.println(pageResultDTO.getTotalPage()); // 20
		System.out.println("===================");
		pageResultDTO.getDtoList()
				.forEach(diaryDTO -> System.out.println(diaryDTO));

	}

	@GetMapping("diary")
	public List<DiaryDTO> getDiary(PageRequestDTO pageRequestDTO) {
//	public List<DiaryDTO> getDiary(int pageno) {
//		System.out.println(pageno);
		System.out.println("===========");
		System.out.println(pageRequestDTO);
		System.out.println("===========");
//		System.out.println(id);
		return diaryImpl.getList(pageRequestDTO).getDtoList();
	}

	@GetMapping("diary/count")
	public int countData() {
		return diaryImpl.getCountData();
	}
}
