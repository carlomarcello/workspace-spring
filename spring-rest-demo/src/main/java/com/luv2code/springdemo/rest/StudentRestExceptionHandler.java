package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * The @ControllerAdvice annotation was first introduced in Spring 3.2. 
 * It allows you to handle exceptions across the whole application, 
 * not just to an individual controller. You can think of it as an 
 * interceptor of exceptions thrown by methods annotated with @RequestMapping
 * or one of the shortcuts.
 * 
 * https://medium.com/@jovannypcg/understanding-springs-controlleradvice-cd96a364033f
 */

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler // handles StudentNotFoundExceptions
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler // handles generic Exceptions
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
}
