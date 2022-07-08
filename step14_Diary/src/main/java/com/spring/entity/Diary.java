package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.DiaryDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Diary implements Persistable<Long>{
	@Id
	private Long no;
	
	private String title;
	
	private String content;
	
	@CreatedDate
	private LocalDateTime writtenTime;

	
	@Override
	public Long getId() {
		
		return no;
	}

	@Override
	public boolean isNew() {
		
		return writtenTime == null;
	}

	//entity ->DTO
	public DiaryDTO toDTO(Diary diaryEntity) {
//		방법 1
		DiaryDTO diaryDTO = DiaryDTO.builder().no(diaryEntity.getNo()).
				title(diaryEntity.getTitle()).writtenTime(diaryEntity.getWrittenTime())
				.content(diaryEntity.getContent()).build();
//		DiaryDTO diaryDTO = DiaryDTO.builder().no(diaryEntity.getNo()).
//				title(diaryEntity.getTitle()).content(diaryEntity.getContent()).build();
// 		방법2. response/request에 대한 DTO를 생성
		return diaryDTO;
	}
}
