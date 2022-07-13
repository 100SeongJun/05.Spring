package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.dto.FileDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "file")
public class FileEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String originalFileName;
	private String fileName;
	private String filePath;

	// 추가될 수도 있는 필드
	// @LastModifiedDate
	// private LocalDateTime modifiedDate;
	// private String createTime;
	public FileDTO toDTO(FileEntity fileEntity) {	
		FileDTO filedto = FileDTO.builder()
				.id(fileEntity.id)
				.fileName(fileEntity.fileName)
				.filePath(fileEntity.filePath)
				.originalFileName(fileEntity.originalFileName).build();
		return filedto;
		
	}
	
}
