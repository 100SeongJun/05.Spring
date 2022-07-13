//package com.board.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.board.dto.PageRequestDTO;
//import com.board.dto.PageResultDTO;
//import com.board.dto.UserDTO;
//import com.board.entity.UserEntity;
//import com.board.service.user.UserServiceImpl;
//
//@RestController
//@CrossOrigin(origins = {"http://localhost:3000"})
//public class UserRestController {
//	@Autowired
//	private UserServiceImpl userService;
//	@GetMapping("/user")
//	public PageResultDTO<UserDTO, UserEntity> getList(PageRequestDTO pRDTO){
//		return userService.getList(pRDTO);
//	}
//}
