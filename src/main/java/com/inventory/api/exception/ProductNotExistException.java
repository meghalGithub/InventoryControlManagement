package com.inventory.api.exception;

public class ProductNotExistException extends RuntimeException{
	public ProductNotExistException(String msg) {
		super(msg);	
	}
}
