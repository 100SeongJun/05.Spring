package com.board.dto;

import java.time.LocalDate;

import com.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
	private String userEmail;
	private String userName;
	private String userPassword;
	private LocalDate registeredDate;
	private LocalDate modifiedDate;

	public UserEntity toEntity(UserDTO userDto) {
		UserEntity userEntity = UserEntity.builder()
				.userEmail(userDto.getUserEmail())
				.userName(userDto.getUserName())
				.userPassword(userDto.getUserPassword())
				.registeredDate(userDto.getRegisteredDate())
				.modifiedDate(userDto.getModifiedDate()).build();
		return userEntity;
	}
}
