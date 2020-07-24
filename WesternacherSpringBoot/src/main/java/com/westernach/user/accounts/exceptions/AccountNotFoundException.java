package com.westernach.user.accounts.exceptions;

public class AccountNotFoundException extends Exception {


	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(long id) {
		super("No account found by this id: " + id);
		
	}

	
	
}
