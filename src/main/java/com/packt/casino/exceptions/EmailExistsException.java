package com.packt.casino.exceptions;

@SuppressWarnings("serial")
public class EmailExistsException extends Throwable {

	public EmailExistsException(final String message) {
		super(message);
	}

}