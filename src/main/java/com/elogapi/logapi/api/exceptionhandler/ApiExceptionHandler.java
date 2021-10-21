package com.elogapi.logapi.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.elogapi.logapi.domain.exception.BusinessException;



@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler
{

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
		List<Problem.Field> fields = new ArrayList<>();
		
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			
			String name = ((FieldError) error).getField();
			String mensage = error.getDefaultMessage();
			
			fields.add(new Problem.Field(name, mensage));
		}
		
		Problem problem = new Problem();
		problem.setStatus(status.value());
		problem.setDateHour(LocalDateTime.now());
		problem.setTitle("One or more fields is empty or null, try again");
		problem.setFields(fields);
		
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusiness(BusinessException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Problem problem = new Problem();
		problem.setStatus(status.value());
		problem.setDateHour(LocalDateTime.now());
		problem.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
}