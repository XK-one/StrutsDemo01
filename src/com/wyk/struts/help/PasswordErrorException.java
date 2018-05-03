package com.wyk.struts.help;

public class PasswordErrorException extends RuntimeException {
	
	public PasswordErrorException(){
		super();
	}
	
	public PasswordErrorException(String msg){
		super(msg);
	}

}
