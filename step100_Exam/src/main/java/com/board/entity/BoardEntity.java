package com.board.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.board.dto.BoardDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "board")
@Entity
@ToString(exclude = {"comments"})
public class BoardEntity  implements Persistable<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardNo;
	@ManyToOne
	@JoinColumn(name = "USER_EMAIL")
	private UserEntity user;
	private String boardTitle;
	private String boardContent;
	@CreatedDate
	private LocalDate registeredDate;
	@LastModifiedDate
	private LocalDate modifiedDate;
	
	@OneToMany(mappedBy = "board")
	@JsonIgnore
	private List<CommentEntity> comments = new ArrayList<CommentEntity>(); 
	
	public BoardDTO toDTO(BoardEntity boardEntity) {
		BoardDTO boardDto = BoardDTO.builder().boardNo(boardEntity.getBoardNo())
				.user(boardEntity.getUser()
						.toDTO(boardEntity.getUser()))
				.boardTitle(boardEntity.getBoardTitle())
				.boardContent(boardEntity.getBoardContent())
				.registeredDate(boardEntity.getRegisteredDate())
				.comments(boardEntity.getComments())
				.modifiedDate(boardEntity.getModifiedDate()).build();
		return boardDto;
	}
	
	public void updateBoard(String boardTitle,String boardContent) {
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	@Override
	public Long getId() {
		return boardNo;
	}

	@Override
	public boolean isNew() {
		return registeredDate !=null;
	}
}

