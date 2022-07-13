package com.board.dto;

import java.time.LocalDate;

import com.board.entity.CommentEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {

	private Long commentNo;
	private String commenter;
	private String commentContent;
	private LocalDate registeredDate;
	private LocalDate modifiedDate;
	private BoardDTO board;
//	private UserDTO user;

	public CommentEntity toEntity(CommentDTO commentDto) {
		CommentEntity commentEntity = CommentEntity.builder()
				.commentNo(commentDto.getCommentNo())
				.commenter(commentDto.getCommenter())
				.commentContent(commentDto.getCommentContent())
				.registeredDate(commentDto.getRegisteredDate())
				.modifiedDate(commentDto.getModifiedDate())
				.board(commentDto.getBoard().toEntity(commentDto.getBoard()))
//				.user(commentDto.getUser().toEntity(commentDto.getUser()))
				.build();
		return commentEntity;
	}
}
