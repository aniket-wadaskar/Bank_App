package com.bankapp.exception;

public class AccountNotFoundException extends RuntimeException{
	
	public AccountNotFoundException() {
		super();
	}
	
	public AccountNotFoundException(String msg) {
		super(msg);
	}

}
