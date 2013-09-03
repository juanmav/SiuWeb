package com.diphot.siuweb.server.business.facade.proxy.exception;

public class NotUserNotPasswordException extends RuntimeException {
	private static final long serialVersionUID = -5382276195386027816L;

	public NotUserNotPasswordException(){
		super();
	}

	public NotUserNotPasswordException(String msg){
		super(msg);
	}
}
