package com.board.service.board;

import com.board.dto.BoardDTO;
import com.board.dto.PageRequestDTO;
import com.board.dto.PageResultDTO;
import com.board.entity.BoardEntity;

public interface BoardService {
	public PageResultDTO<BoardDTO, BoardEntity> getList(PageRequestDTO pRDTO) ;
	public void insertBoard(BoardDTO boardDto);
	public void updateBoard(BoardDTO boardDto);
	public void deleteBoard(Long boardNo);
	public BoardDTO getOne(BoardDTO boardDto);
}
