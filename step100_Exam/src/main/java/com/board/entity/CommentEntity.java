package com.board.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.board.dto.CommentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comment")
@Entity
public class CommentEntity implements Persistable<Long>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentNo;
	private String commenter;
	private String commentContent;
	@CreatedDate
	private LocalDate registeredDate;
	@LastModifiedDate
	private LocalDate modifiedDate;
	@ManyToOne
	@JoinColumn(name = "board_no")
	private BoardEntity board;
	
//	@ManyToOne
//	@JoinColumn(name = "user_email")
//	private UserEntity user;

	public CommentDTO todto(CommentEntity commentEntity) {

		CommentDTO commentDto = CommentDTO.builder()
				.commentNo(commentEntity.getCommentNo())
				.commenter(commentEntity.getCommenter())
				.commentContent(commentEntity.getCommentContent())
				.registeredDate(commentEntity.getRegisteredDate())
				.modifiedDate(commentEntity.getModifiedDate())
				.board(commentEntity.getBoard().toDTO(commentEntity.getBoard()))
//				.user(commentEntity.getUser().toDTO(commentEntity.getUser()))
				.build();
		return commentDto;
	}
	public void update(CommentDTO commentDto) {
		this.commentContent = commentDto.getCommentContent();
		this.commenter= commentDto.getCommenter();
	}
	@Override
	public Long getId() {
		return commentNo;
		
	}
	@Override
	public boolean isNew() {

		return registeredDate !=null;
	}
}
