package com.westernach.user.accounts.exceptions;

public class EmailNotWellFormedExceptoin extends Exception {

	public EmailNotWellFormedExceptoin(String  email) {
		super("Email not well formad " + email);
	}
}
