package com.capgemini.onlinetestmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=ExamException.class)
	public ResponseEntity<Object> notFoundException(ExamException examException){
		return new ResponseEntity<>(examException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(value=UserExceptions.class)
	public ResponseEntity<Object> messageNotFound(UserExceptions userException){
		return new ResponseEntity<>(userException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value=AssignExamUserException.class)
	public ResponseEntity<Object> messageNotFound(AssignExamUserException assignExamUserException){
		return new ResponseEntity<>(assignExamUserException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
}
