package com.board.service.user;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.board.dto.PageRequestDTO;
import com.board.dto.PageResultDTO;
import com.board.dto.UserDTO;
import com.board.entity.UserEntity;
import com.board.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public PageResultDTO<UserDTO, UserEntity> getList(PageRequestDTO pRDTO) {
		Pageable pageable = pRDTO.getPageable(Sort.by("userEmail").ascending());
		Page<UserEntity> result = userRepo.findAll(pageable);
		Function<UserEntity, UserDTO> function = (userEntity-> userEntity.toDTO(userEntity));
		return new PageResultDTO<UserDTO, UserEntity>(result, function);	
	}

	@Override
	public void saveBoard() {
		
	}
	
}
