package com.capgemini.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class exceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(value=IdDoesNotExist.class)
	public ResponseEntity<Object> noID(IdDoesNotExist noID)
	{
		return new ResponseEntity<>("The given ID does not exist", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=DuplicateID.class)
	public ResponseEntity<Object> duplicateID(DuplicateID duplicate)
	{
		return new ResponseEntity<>("The product with the given ID already exists", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=EmptyList.class)
	public ResponseEntity<Object> emptyList(EmptyList emptyList)
	{
		return new ResponseEntity<>("Sorry! There are no products available", HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		return new ResponseEntity<>(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
