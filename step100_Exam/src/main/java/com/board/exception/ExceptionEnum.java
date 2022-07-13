package com.board.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ExceptionEnum {
	NOT_FOUND(HttpStatus.NOT_FOUND, "404"),
	SECURITY_001(HttpStatus.NOT_FOUND, "404", "Not Found"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"INTERMAL_SERVER_ERROR");
	
	
	private final HttpStatus status;
	private final String code;
	private String message;
	
	ExceptionEnum(HttpStatus status, String code) {
		this.status = status;
		this.code = code;
	}

	ExceptionEnum(HttpStatus status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
	
}
