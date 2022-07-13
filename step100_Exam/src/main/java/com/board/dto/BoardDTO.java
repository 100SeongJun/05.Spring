package com.board.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.board.entity.BoardEntity;
import com.board.entity.CommentEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
	private Long boardNo;
	private UserDTO user;
	private String boardTitle;
	private String boardContent;
	private LocalDate registeredDate;
	private LocalDate modifiedDate;
	private List<CommentEntity> comments = new ArrayList<CommentEntity>(); 
	public BoardEntity toEntity(BoardDTO boardDto) {
 
		BoardEntity boardEntity = BoardEntity.builder()
				.boardNo(boardDto.getBoardNo())
				.user((boardDto.getUser().toEntity(boardDto.getUser())))
				.boardTitle(boardDto.getBoardTitle())
				.comments(boardDto.getComments())
				.boardContent(boardDto.getBoardContent()).build();

		return boardEntity;
	}
	

}
