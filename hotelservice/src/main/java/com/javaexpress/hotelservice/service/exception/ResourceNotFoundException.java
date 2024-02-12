package com.javaexpress.hotelservice.service.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(){
		super();
		
	}
	
	public ResourceNotFoundException(String s){
		super(s);
		
	}

}
