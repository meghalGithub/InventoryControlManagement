package com.inventory.api.exception;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException(String msg) {
		super(msg);	
  }
}
