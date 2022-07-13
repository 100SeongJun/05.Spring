package com.board.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionAdvice {
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ApiExceptionEntity> exceptionHandler(
			HttpServletRequest request, final Exception e) {
		e.printStackTrace();
		return (ResponseEntity<ApiExceptionEntity>) ResponseEntity
				.status(ExceptionEnum.NOT_FOUND.getStatus())
				.body(ApiExceptionEntity.builder()
						.errorCode(ExceptionEnum.NOT_FOUND.getCode())
						.errorMessage(e.getMessage()).build());
	}

}
