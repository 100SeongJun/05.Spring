package com.board.service.user;

import com.board.dto.PageRequestDTO;
import com.board.dto.PageResultDTO;
import com.board.dto.UserDTO;
import com.board.entity.UserEntity;

public interface UserService {
	public PageResultDTO<UserDTO, UserEntity> getList(PageRequestDTO pRDTO);
	public void saveBoard();
}
