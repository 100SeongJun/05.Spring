package com.board.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.board.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
@Entity
public class UserEntity {
	@Id	@Column(name = "USER_EMAIL")
	private String userEmail;
	private String userName;
	private String userPassword;
	private LocalDate registeredDate;
	private LocalDate modifiedDate;
	
	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO userDto = UserDTO.builder()
				.userEmail(userEntity.getUserEmail())
				.userName(userEntity.getUserName())
				.userPassword(userEntity.getUserPassword())
				.registeredDate(userEntity.getRegisteredDate())
				.modifiedDate(userEntity.getModifiedDate()).build();
		return userDto;
	}
}
