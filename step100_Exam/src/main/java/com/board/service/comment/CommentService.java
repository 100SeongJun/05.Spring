package com.board.service.comment;

import java.util.List;

import com.board.dto.CommentDTO;

public interface CommentService {
	public List<CommentDTO> listComment(Long boardNo);
	public void deleteComment(Long commentNo);
	public void updateComment(CommentDTO commentDto);
	public void insertComment(CommentDTO commentDto);
}
