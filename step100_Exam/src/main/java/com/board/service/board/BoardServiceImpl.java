package com.board.service.board;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.board.dto.BoardDTO;
import com.board.dto.PageRequestDTO;
import com.board.dto.PageResultDTO;
import com.board.entity.BoardEntity;
import com.board.repository.BoardRepo;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepo boardRepo;

	@Override
	public PageResultDTO<BoardDTO, BoardEntity> getList(PageRequestDTO pRDTO) {
		Pageable pageable = pRDTO.getPageable(Sort.by("boardNo").ascending());
		Page<BoardEntity> result = boardRepo.findAll(pageable);
		Function<BoardEntity, BoardDTO> function = (userEntity -> userEntity
				.toDTO(userEntity));
		return new PageResultDTO<BoardDTO, BoardEntity>(result, function);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDto) {
		BoardEntity boardEntity = boardDto.toEntity(boardDto);
		Optional<BoardEntity> boardResult = boardRepo
				.findById(boardEntity.getBoardNo());
		System.out.println(boardResult);
		if (boardResult.get().getBoardNo() != null) {
			return boardResult.get().toDTO(boardResult.get());
		}
		return null;
	}

	@Override
	public void insertBoard(BoardDTO boardDto) {
		BoardEntity boardEntity = boardDto.toEntity(boardDto);
		boardRepo.save(boardEntity);
	}

	@Override
	public void updateBoard(BoardDTO boardDto) {
//		BoardEntity boardEntity = boardDto.toEntity(boardDto);
		Optional<BoardEntity> oldBoard = boardRepo
				.findById(boardDto.toEntity(boardDto).getBoardNo());
		oldBoard.get().updateBoard(boardDto.getBoardTitle(),boardDto.getBoardContent());
		
		if(oldBoard.get().getBoardNo() !=null) {
			boardRepo.save(oldBoard.get());
		}
	}

	@Override
	public void deleteBoard(Long boardNo) {
		Optional<BoardEntity> board = boardRepo.findById(boardNo);
		if (board != null) {
			boardRepo.delete(board.get());
		}
	}

}
