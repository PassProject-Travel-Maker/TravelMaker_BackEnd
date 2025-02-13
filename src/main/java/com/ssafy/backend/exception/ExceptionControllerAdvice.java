package com.ssafy.backend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalException(Exception ex){
		log.debug("오류발생 : {}",ex.getMessage());
		ex.printStackTrace();
		
		return ResponseEntity.status(500).build();
	}
}
