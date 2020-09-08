package com.manipal.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.manipal.exception.ExceptionResponse;
import com.manipal.exception.MovieNotFoundException;
@ControllerAdvice
public class MovieResponseExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<ExceptionResponse> movieNotFound(MovieNotFoundException exception){
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
		return new ResponseEntity<> (response, HttpStatus.NOT_FOUND);
	}
}
