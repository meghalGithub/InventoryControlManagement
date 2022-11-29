package com.inventory.api.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inventory.api.error.ErrorResponseClass;

@RestControllerAdvice
public class GlobalHandlerException {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> productNotFoundException(ProductNotFoundException ex){
		ErrorResponseClass response = new ErrorResponseClass(ex.getMessage(), new Date());
		return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> response = new HashMap<>();
     	ex.getBindingResult().getFieldErrors().forEach(error ->{
			response.put(error.getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler(ProductNotExistException.class)
	public ResponseEntity<Object> productNotExistException(ProductNotExistException ex){
		ErrorResponseClass response = new ErrorResponseClass(ex.getMessage(), new Date());
		return new ResponseEntity<Object>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(SupplierListIsEmpty.class)
	public ResponseEntity<Object> supplierListIsEmpty(SupplierListIsEmpty ex){
		ErrorResponseClass response = new ErrorResponseClass(ex.getMessage(), new Date());
		return new ResponseEntity<Object>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
 }