package com.devsuperior.dslearnbds.services.exceptions;

public class UnauthorazedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnauthorazedException(String msg) {
		super(msg);
	}
}
