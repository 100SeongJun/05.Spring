package com.board.service.comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dto.CommentDTO;
import com.board.entity.CommentEntity;
import com.board.repository.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepo commentRepo;

	@Override
	public List<CommentDTO> listComment(Long boardNo) {
		List<CommentEntity> comment = commentRepo
				.findAllByBoardBoardNo(boardNo);
		List<CommentDTO> commentDto = new ArrayList<CommentDTO>();
		for (CommentEntity commentEntity : comment) {
			commentDto.add(commentEntity.todto(commentEntity));
		}

		return commentDto;
	}

	@Override
	public void deleteComment(Long commentNo) {
		CommentEntity comment = commentRepo.findById(commentNo).get();
		if (comment != null) {
			commentRepo.delete(comment);
		}
	}

	@Override
	public void updateComment(CommentDTO commentDto) {
		Long commentNo = commentDto.toEntity(commentDto).getCommentNo();
		Optional<CommentEntity> comment = commentRepo.findById(commentNo);
		CommentEntity commentEntity = comment.get();
		if (comment != null) {
			commentEntity.update(commentDto);
			commentRepo.save(commentEntity);
		}
	}

	@Override
	public void insertComment(CommentDTO commentDto) {
		System.out.println(commentDto.getBoard());
		
		CommentEntity comment = commentDto.toEntity(commentDto);
		commentRepo.save(comment);
	}

}
