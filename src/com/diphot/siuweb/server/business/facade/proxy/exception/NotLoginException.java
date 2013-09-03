package com.diphot.siuweb.server.business.facade.proxy.exception;

public class NotLoginException extends RuntimeException{	
	
	private static final long serialVersionUID = 1L;
	public NotLoginException (String msg){
		super(msg);
	}
	
	public NotLoginException (){
		super();
	}

	
}
